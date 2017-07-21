/**
 * Created by qqc on 2017/3/7.
 */
(function () {
    var changeBtn = document.getElementById('change_btn');
    var extraGroup = document.getElementById('extra_group');
    var saveBtn = document.getElementById('save_btn');
    var inputArray = document.querySelectorAll('#school_form input');
    changeBtn.addEventListener('click', function () {
        console.log('修改');
        for (var i = 0; i < inputArray.length; i++) {
            inputArray[i].disabled = false;
        }

        extraGroup.style.display = 'block';
        this.style.display = 'none';

    });
    saveBtn.addEventListener('click', function () {
        console.log('保存');
        for (var i = 0; i < inputArray.length; i++) {
            inputArray[i].disabled = true;
        }

        extraGroup.style.display = 'none';
        changeBtn.style.display = 'block';
    });

})();