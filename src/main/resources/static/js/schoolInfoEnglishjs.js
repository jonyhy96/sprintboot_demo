/**
 * Created by qqc on 2017/3/16.
 */
/**
 * Created by qqc on 2017/3/7.
 */
(function () {
    var changeBtn = document.getElementById('change_btn');
    var extraGroup = document.getElementById('extra_group');
    var saveBtn = document.getElementById('save_btn');
    var translateInput = document.getElementById('translateInfo');
    changeBtn.addEventListener('click', function () {
        console.log('修改');
        translateInput.disabled = false;
        extraGroup.style.display = 'block';
        this.style.display = 'none';

    });
    saveBtn.addEventListener('click', function () {
        console.log('保存');
        translateInput.disabled = true;
        extraGroup.style.display = 'none';
        changeBtn.style.display = 'block';
    });

})();