/**
 * Created by qqc on 2017/3/8.
 */
(function () {
    var AddForm = function () {
        this.addButton = document.getElementById('add');
        this.el = document.getElementById('add_form');
        this.diplomaTable = document.getElementById('chineseDiploma_table');
        this.screenForm = document.getElementById('screen_form');
        this.state = 'closed';//表示当前添加表单未出现
        var self = this;
        this.addButton.addEventListener('click',function () {
            if (self.state=='closed'){
                console.log('显示:'+self.el.id);
                self.state='opened';
                self.el.className = 'add_form form-horizontal';
                self.el.style.display = 'block';
                self.el.classList.add('show_form');
                this.className = 'add';
                this.classList.add('close_button');
                self.diplomaTable.classList.add('move_down');
                self.screenForm.classList.add('move_down');


            }else {
                console.log('隐藏:'+self.el.id);
                self.state='closed';
                self.el.className = 'add_form form-horizontal';
                self.el.style.display = 'none';
                self.el.classList.add('hide_form');
                this.className = 'add';
                this.classList.add('add_button');
                self.diplomaTable.classList.add('move_up');
                self.screenForm.classList.add('move_up');
            }
        });
    };

    var addform = new AddForm();
})();