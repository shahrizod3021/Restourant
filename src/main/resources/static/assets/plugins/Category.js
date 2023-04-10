$(document).ready(function () {
    let id = ''
    let categoryTable = $('#categoryjonTable').DataTable({
        ajax: {
            url: '/dashboard/category/list',
            method: 'GET',
            dataSrc: ''
        },
        columns: [
            {title: 'T/r', data: 'id'},
            {title: 'name', data: 'name'},
            {title: 'active', data: 'active'},
            {title: 'mahsulotlar', data: 'mahsulotlar'},
            {
                title: 'action', data: 'id',
                render: function () {
                    return "<div class='row'><div class='col-3'><button class='btn btn-primary' id='edit' data-bs-target=\"#categoryEditModal\" data-bs-toggle=\"modal\"><i class='bi-pen'></i></button></div>" +
                        "<div class='col-3'><button class='btn btn-primary' id='delete'  data-bs-target=\"#categoryDeleteModal\" data-bs-toggle=\"modal\"><i class='bi-trash'></i></button></div></div>"
                }
            }
        ]
    })


    $('#saveCategory').click(function (){
        let name = document.getElementById('name').value;
        let photo = document.getElementById('photo').value;
        if (name.trim().length === 0){
            return alert('malumot bosh')
        }
        if (photo.trim().length === 0){
            return alert("rasm kiritmadingiz")
        }
        let obj = {name, photo};
        $.ajax({
            url: '/dashboard/category',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(obj)
        })
        alert("category saqlandi")
        window.location.reload()
    })

    $(categoryTable.table().body).on('click', '#delete', function () {
        let data = categoryTable.row($(this).parents('tr')).data();
        id = data.id;
    })
    $(categoryTable.table().body).on('click', '#edit', function () {
        let data = categoryTable.row($(this).parents('tr')).data();
        id = data.id;
    })

    $('#deleteCategory').click(function (){
        $.ajax({
            url: '/dashboard/category/' + id,
            method: 'DELETE',
        })
        alert('ochirildi')
        window.location.reload()
    })

    $('#editCategory').click(function (){
        let name = document.getElementById('editname').value;
        let photo = document.getElementById('editPhoto').value;
        if (name.trim().length === 0){
            return alert('malumot bosh')
        }
        if (photo.trim().length === 0){
            return alert("rasm kiritmadingiz")
        }
        let obj = {name, photo}
        $.ajax({
            url: '/dashboard/category/edit/' + id,
            method: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(obj)
        })
        alert("taxrirlandi")
        window.location.reload();
    })
})


