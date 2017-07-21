/**
 * Created by qqc on 2017/3/13.
 */

(function () {
    var selectForm = function () {
        window.onload = function () {
            function stopPropagation(e) {
                if (e.stopPropagation) {
                    e.stopPropagation();
                } else {
                    e.cancelBubble = false;
                }
            }
        };
        this.selectState = document.getElementById('select_state');
        this.formSelect = document.getElementById('form_select');
        this.listItems = document.querySelectorAll('#form_select ul li');
        this.tableContainer = document.getElementById('table_container');
        this.tableContent = document.getElementById('table_content');
        this.showedCount = 0;
        for (var j = 0;j<this.listItems.length;j++){
            this.listItems[j].states = 'hidden';
        }
        var self = this;
        this.selectState.addEventListener('click',function (e) {
            var positionX = e.pageX;
            var positionY = e.pageY;
            self.formSelect.style.left = positionX+'px';
            self.formSelect.style.top = positionY+'px';
            self.formSelect.style.opacity = 1;
            e.stopPropagation();
            window.onclick = function (e) {
                self.formSelect.style.opacity = 0;
            };
            for (var i =0;i<self.listItems.length;i++){
                self.listItems[i].addEventListener('click',selectItem);
            }
    });

    function selectItem(event) {
        console.log(this.states);
        if (this.states == 'hidden'){
            this.states = 'showed';
            this.className='selected_item';
            self.showedCount ++;
            self.formSelect.style.opacity = 0;
            console.log('加列：' + this.innerHTML);
            self.tableContainer.style.width = 980+'px';
            self.tableContent.style.width = 1000+'px';
            for (var m = 1; m <= document.getElementsByTagName("tr").length; m++) {
                var td = document.createElement("td");
                var th = document.createElement('th');
                if (m == 1){
                    th.innerHTML = this.innerHTML;
                    document.getElementsByTagName("tr")[m - 1].appendChild(th);
                }
                else{
                    td.innerHTML = '';
                    document.getElementsByTagName("tr")[m - 1].appendChild(td);
                }

            }
        }else if(this.states == 'showed'){
            this.states = 'hidden';
            this.className='';
            self.showedCount--;
            if (self.showedCount==0){
                self.tableContainer.style.width = 'auto';
                self.tableContent.style.width = 'auto';
            }
            self.formSelect.style.opacity = 0;
            console.log('去列：' + this.innerHTML);
            var trList = document.getElementsByTagName("tr");
            var thList = trList[0].querySelectorAll('th');
            for (var i = 0;i<thList.length;i++){
                if (thList[i].innerHTML==this.innerHTML){
                    trList[0].removeChild(thList[i]);
                    for (var k = 1;k<trList.length;k++){
                        var tdList = trList[k].querySelectorAll('td');
                        trList[k].removeChild(tdList[i]);
                    }
                }
            }
        }



    }};
    var ChangeForm = function () {
      this.changeBtn = document.getElementsByClassName('change_btn');
      this.tableContent = document.getElementById('table_content');
      var self = this;

      for (var i = 0;i<this.changeBtn.length;i++){
          this.changeBtn[i].addEventListener('click',function (event) {fn(event,self)});
          console.log('aaa');
      }
    };

    function fn(event,self) {
        // console.log(self.num);
        //  显示表格的全部列表项
        var completeTable = '<table class="table table-bordered table-striped complete_table" id="complete_table"><thead id="select_state"><tr><th>编号</th><th>学号</th><th>姓名</th><th>专业名称</th><th>毕业结论</th><th>毕业证书号</th><th>学位类别</th><th>学位证书号</th><th>考生号</th><th>姓名拼音</th><th>性别</th><th>性别码</th><th>学院</th><th>专业代码</th><th>证书专业名称</th><th>班级</th><th>学制</th><th>层次</th><th>入学日期</th><th>证书类型</th><th>证书类型码</th><th>证件号码</th><th>民族</th><th>出生日期</th><th>政治面貌（学位）</th><th>政治面貌码</th><th>政治面貌（学历）</th><th>毕业日期</th><th>学位类别码</th><th>打印标记</th><th>备注</th><th>培养单位</th><th>培养单位码</th><th>校长姓名</th><th>主席姓名</th><th>学位授予单位码</th><th>学位授予单位</th><th>是否第二学位</th><th>是否辅修学位</th><th>学习形式</th><th>学生号</th><th>预计毕业日期</th><th>操作</th></tr></thead><tbody><tr><td>1</td><td class="revisability_td">2016541310</td><td class="revisability_td">王五</td><td class="revisability_td">计算机</td><td>已毕业</td><td>471398572</td><td>学士学位</td><td>学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">471398572</td><td><a href="javascript:void(0);" class="btn btn-primary change_btn">修改</a><a href="#" class="btn btn-default" data-toggle="modal" data-target="#deleteModal">删除</a></td></tr><tr><td>1</td><td class="revisability_td">2016541310</td><td class="revisability_td">王五</td><td class="revisability_td">计算机</td><td>已毕业</td><td>471398572</td><td>学士学位</td><td>学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">学士学位</td><td class="revisability_td">471398572</td><td><a href="javascript:void(0);" class="btn btn-primary change_btn">修改</a><a href="javascript:void(0);" class="btn btn-default" data-toggle="modal" data-target="#deleteModal">删除</a></td></tr></tbody></table>';
        self.tableContent.innerHTML = completeTable;
        // //  将表格中所有的可修改项改成input控件
        event.target.completetr = document.querySelectorAll('#complete_table tr');
        event.target.inputtd=event.target.completetr[event.target.parentNode.parentNode.rowIndex].getElementsByClassName('revisability_td');
        var changeBtn = document.getElementsByClassName('change_btn');
        changeBtn[event.target.parentNode.parentNode.rowIndex-1].innerHTML = '保存';
        changeBtn[event.target.parentNode.parentNode.rowIndex-1].className = 'btn btn-success save_btn';

        console.log(changeBtn.length);
        for (var num = 0;num<changeBtn.length;num++){
            console.log(num);
            // if (num!=event.target.parentNode.parentNode.rowIndex-1){
                // console.log(num);
            changeBtn[num].classList = 'btn btn-primary disabled change_btn';
                // changeBtn[num].addEventListener('click',function (event) {
                //     fn(event,self);
                // });
            // }
        }

        var changeSelf = event.target;
        for (var j = 0;j<event.target.inputtd.length;j++){
            var inputText = '<input type="text" class="form-control"/>';
            event.target.inputtd[j].innerHTML = inputText;
        }
        saveBtns = document.getElementsByClassName('save_btn');
        for (var j = 0;j<saveBtns.length;j++){
            saveBtns[j].addEventListener('click',function () {
                this.className = 'btn btn-primary change_btn';
                this.innerHTML = '修改';
                this.addEventListener('click',function (event) {fn(event,self)});
                for (var num = 0;num<changeSelf.inputtd.length;num++){
                    changeSelf.inputtd[num].innerHTML = '';
                }
                for (var k = 0;k<changeBtn.length;k++){
                    changeBtn[k].classList = 'btn btn-primary change_btn';
                    changeBtn[k].addEventListener('click',function (event) {
                        fn(event,self);
                    });
                }
            });
        }
    }
    var select_form = new selectForm();
    var change_form = new ChangeForm();
})();