/**
 * Created by qqc on 2017/3/30.
 */
(function () {
    var ShowForm = function () {
        this.searchButton = document.getElementById('search');
        this.search = document.querySelector('#search span');
        this.el = document.getElementById('search_form');
        this.addContainer = document.getElementById('add_container');
        this.tableContainer = document.getElementById('table_container');
        this.state = 'closed';//表示当前添加表单未出现
        var self = this;
        this.searchButton.addEventListener('click',function () {
            if (self.state=='closed'){
                console.log('显示:'+self.el.id);
                self.state='opened';
                self.el.className = 'search_form form-horizontal';
                self.el.style.display = 'block';
                self.el.classList.add('show_form');
                self.search.className = 'fui-plus';
                this.className = 'search';
                this.classList.add('close_button');
                self.addContainer.classList.add('move_down');
                self.tableContainer.classList.add('move_down');



            }else {
                console.log('隐藏:'+self.el.id);
                self.state='closed';
                self.el.className = 'search_form form-horizontal';
                self.el.style.display = 'none';
                self.el.classList.add('hide_form');
                self.search.className = 'fui-search';
                this.className = 'search';
                this.classList.add('search_button');
                self.addContainer.classList.add('move_up');
                self.tableContainer.classList.add('move_up');
            }
        });
    };

    var showform = new ShowForm();
})();