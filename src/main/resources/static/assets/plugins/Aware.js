$(document).ready(function (){
    let id = ''
    let awareTabel = $('#awarejonTable').DataTable({
        ajax: {
            url: '/dashboard/aware/list',
            method: 'GET',
            dataSrc: ''
        },
        columns: [
            {title: 'T/r', data: 'id'},
            {title: 'name', data: 'name'},
            {title: 'link', data: 'link'},
            {title: 'color', data: 'color'},
            {
                title: 'action', data: 'id',
                render: function () {
                    return "<div class='row'><div class='col-3'><button class='btn btn-warning' data-bs-target=\"#awareEditModal\" data-bs-toggle=\"modal\" id='edit' ><i class='bi-pen'></i></button></div>" +
                        "<div class='col-3'><button class='btn btn-warning' data-bs-target=\"#awareDeleteModal\" data-bs-toggle=\"modal\" id='delete'><i class='bi-trash' ></i></button></div></div>"
                }
            }
        ]
    })

    $('#saveAware').click(function (){
        let name = document.getElementById('name').value
        let link = document.getElementById('link').value
        let color = document.getElementById('color').value
        if (name.trim().length === 0){
            return alert("nomini kiritmadingiz")
        }
        if (link.trim().length === 0){
            return alert("linkini kiritmadingiz")
        }
        if (!link.startsWith("http")){
            return alert("link hato")
        }
        if (color.trim().length === 0){
            return alert("color kiritlmadi")
        }
        let obj  = {name, link, color}
        $.ajax({
            url: '/dashboard/aware',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(obj)
        })
        alert("aware saqlandi")
        window.location.reload()
    })


    $(awareTabel.table().body).on('click', '#delete', function () {
        let data = awareTabel.row($(this).parents('tr')).data();
        id = data.id;
    })

    $(awareTabel.table().body).on('click', '#edit', function () {
        let data = awareTabel.row($(this).parents('tr')).data();
        id = data.id;
    })

    $('#deleteAware').click(function (){
        $.ajax({
            url: '/dashboard/aware' + id,
            method: 'DELETE'
        })
        alert('ochirildi')
        window.location.reload()
    })

    $('#editAware').click(function (){
        let name = document.getElementById('editaName').value;
        let link = document.getElementById('editLink').value;
        let color = document.getElementById('editColor').value;
        if (name.trim().length === 0){
            return alert("nomini kiritmadingiz")
        }
        if (link.trim().length === 0){
            return alert("linkini kiritmadingiz")
        }
        if (!link.startsWith("http")){
            return alert("link hato")
        }
        if (color.trim().length === 0){
            return alert("color kiritilmadi")
        }
        let obj = {name, link, color}
        $.ajax({
            url: '/dashboard/aware/edit/'+id,
            method: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(obj)
        })
        alert('taxrirlandi')
        window.location.reload()
    })
})