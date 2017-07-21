/**
 * Created by qqc on 2017/3/15.
 */
(function () {
    var ChangeInfo = function () {
        this.changeBtns = document.getElementsByClassName('change_btn');
        this.states = 'change';
        var self = this;
        for (var i = 0;i<this.changeBtns.length;i++){
            self.changeBtns[i].addEventListener('click',function () {
                var name = this.parentNode.previousElementSibling.previousElementSibling;
                var changeInput = '<input class="form-control" id="changeName" type="text" value="'+name.innerHTML+'"/>';

                if (self.states == 'change'){
                    self.states = 'save';
                    name.innerHTML = changeInput;
                    this.innerHTML = '保存';

                    for (var j =0;j<self.changeBtns.length;j++){
                        self.changeBtns[j].classList = 'btn change_btn btn-default disabled';
                    }
                    this.classList = 'btn btn-primary change_btn';

                }else if (self.states == 'save'){
                    self.states = 'change';
                    this.innerHTML = '修改';
                    var nameInput = document.getElementById('changeName');
                    name.innerHTML = nameInput.value;

                    for (var j =0;j<self.changeBtns.length;j++){
                        self.changeBtns[j].classList = 'btn change_btn btn-primary';
                    }
                }

            });
        }

    }
    var changeInfo = new ChangeInfo();
})();