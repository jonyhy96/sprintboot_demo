/**
 * Created by qqc on 2017/3/10.
 */
(function () {
    var selectAll = function () {
        this.all_btn = document.getElementById('all_btn');
        this.checkboxList = document.querySelectorAll('#add_table input');
        this.state = 'selectedAll';
        var self = this;
        this.all_btn.addEventListener('click',function () {
            if (self.state=='selectedAll'){
                self.state = 'selectedNone';
                for (var i = 0;i<self.checkboxList.length;i++){
                    self.checkboxList[i].checked = true;
                }
                self.all_btn.innerHTML = '全不选';
            }else {
                self.state = 'selectedAll';
                for (var i = 0;i<self.checkboxList.length;i++){
                    self.checkboxList[i].checked = false;
                }
                self.all_btn.innerHTML = '全选';
            }
        });
    }
    selectAll();
})();