//当前数组下标
var idx = 0;
//存放待打印学生id数组
var studentIds;
//打印任务id
var printTaskId;
//是否开始打印
var startPrint = false;
//结束打印
var endPrint = false;

var printedNum;

var busy;

/*
 学生证书信息
 */
var studentPrintInfo = new Vue({
    el: '#printArea',
    data: {
        student: {
            id: '',
            name: '',
            birthYear: '',
            birthMonth: '',
            birthDay: '',
            entranceYear: '',
            entranceMonth: '',
            graduateYear: '',
            graduateMonth: '',
            major: '',
            eduLength: '',
            chineseEduLength: '',
            eduType: '',
            eduTypeShort: '',
            school: '',
            principal: '',
            byNo: '',
            xwNo: '',
            printYear: '',
            printMonth: '',
            printDay: '',
            chineseBirthYear: '',
            chineseBirthMonth: '',
            chineseBirthDay: '',
            chineseEntranceYear: '',
            chineseEntranceMonth: '',
            chineseGraduateYear: '',
            chineseGraduateMonth: '',
            chinesePrintYear: '',
            chinesePrintMonth: '',
            chinesePrintDay: '',
            nameEn: '',
            majorEn: '',
            englishEntranceDate: '',
            englishGraduateDate: '',
            englishPrintDate: '',
            nationality: '',
            englishDegree: '',
            englishDegreeType: '',
            englishCity: '',
            englishDegreeDay: '',
            englishDegreeMonth: '',
            degreeYear: '',
            englishPresident: '',
            englishZUST: '',
            schoolAndMajor: '',
            degreeType: '',
            englishByYear: '',
            englishDegreeYear: '',
            chineseGraduateDay:'',
            graduateDay:'',
            englishGraduateDateWithDay:'',

        },
    }
})


$(document).ready(function () {
    var studentIdsStr = $("#toPrintStudentsIds").val();
    studentIds = studentIdsStr.split(';');
    printTaskId = $("#printTaskId").val();

    printedNum = $("#finished").html();

    /*
     模拟每五秒执行一次检查是否在打印
     */
    setInterval(checkIfPrinting, 5000);

})

function pagePrintOver() {
    console.log("page print finish,do another one")
    busy = false;
}

/*
 检查是否在打印
 */
function checkIfPrinting() {
    if (startPrint) {
        /*
         如果在打印，调用打印函数
         */
        var studentId = studentIds[idx++];
        if (studentId == null || studentId == "" || studentId.length == 0) {
            /*
             打印结束
             */
            endPrint = true;
            $("#start_btn").html("打印完成");
            $("#nowStudentName").html("xxx");
            clearPageCertificateFields();
        } else {
            /*
             显示正在打印信息
             */


            var printStatusTd = $("#printStatus" + studentId);
            var status = "<label class='label label-default'>正在打印</label>"
            printStatusTd.html("");
            printStatusTd.append(status);

            /*
             获取学生信息
             */
            getStudentPrintInfo(studentId);


        }

    }
}
/*
 打印证书
 */
function changePrintCertificateStatus(printTaskId, studentId) {
    $.ajax({
        url: basePath + "print/" + printTaskId + "/printed/" + studentId,
        type: 'PUT',
        success: function (data) {
            if (data.success) {
                var printStatusTd = $("#printStatus" + studentId);
                printStatusTd.html("");
                if (data.success) {
                    //打印成功，打印状态改为已打印
                    var status = "<label class='label label-success'>已打印</label>";

                    /*
                     让打印机打印
                     */
                    PrintArea.print2($("#printArea"));

                    //修改页面已打印份数
                    console.log(printedNum);
                    printedNum++;
                    console.log(printedNum);
                    $("#finished").html(printedNum);

                } else {
                    //打印失败，打印标记改为打印失败
                    var status = "<label class='label label-danger'>打印失败</label>";
                }
                printStatusTd.append(status);
            } else {
                alert("修改打印标记失败！");
            }
        }
    })
}

/**
 * 修改打印状态
 */
function changePrintStatus() {
    if (!endPrint) {
        //切换打印状态
        startPrint = !startPrint;
        if (startPrint) {
            //正在打印，点击按钮暂停打印
            $("#start_btn").html("暂停打印");
            PrintArea.init({mode: "iframe", popClose: true, cb: pagePrintOver});
        } else {
            //未在打印,点击按钮开始打印
            $("#start_btn").html("开始打印");
            clearPageCertificateFields();
        }
    }

}

/**
 * 获取学生证书打印信息
 * @param studentId
 */
function getStudentPrintInfo(studentId) {
    $.ajax({
        url: basePath + "print/" + studentId + "/cerInfo",
        type: 'GET',
        data: {
            certificateTypeCode: $("#certificateTypeCode").val()
        },
        success: function (data) {
            if (data.success) {
                var student = data.data;
                studentPrintInfo.student = student;
                console.log(studentPrintInfo.student);
                /*
                 修改正在打印学生姓名
                 */
                var studentName = student.name;
                $("#nowStudentName").html('"' + studentName + '"');
                /*
                 修改数据库中打印状态
                 */
                changePrintCertificateStatus(printTaskId, studentId);
            } else {
                alert("获取学生信息失败！");
            }
        }
    })
}


/**
 * 清空页面证书值
 */
function clearPageCertificateFields() {
    $("#printName").html("");
    $("#printGender").html("");
    $("#printBirthYear").html("");
    $("#printBirthMonth").html("");
    $("#printBirthDay").html("");
    $("#printEntranceYear").html("");
    $("#printEntranceMonth").html("");
    $("#printGraduateYear").html("");
    $("#printGraduateMonth").html("");
    $("#printMajor").html("");
    $("#printEduLength").html("");
    $("#printEduType").html("");
    $("#printSchool").html("");
    $("#printPrincipal").html("");
    $("#printCerNo").html("");
    $("#printDateYear").html("");
    $("#printDateMonth").html("");
    $("#printDateDay").html("");
}