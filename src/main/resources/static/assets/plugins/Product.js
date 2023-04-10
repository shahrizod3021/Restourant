$(document).ready(function (){
    let id = ''
    let productTable = $('#productjonTable').DataTable({
        ajax: {
            url: '/dashboard/product/list',
            method: 'GET',
            dataSrc: ''
        },
        columns: [
            {title: 'T/r', data: 'id'},
            {title: 'name', data: 'name'},
            {title: 'price', data: 'price'},
            {title: 'description', data: 'description'},
            {title: 'action', data: 'id',
                render: function (){
                    return "<div class='row'><div class='col-3'><button class='btn btn-danger' data-bs-target=\"#productEditModal\" data-bs-toggle=\"modal\" id='edit'><i class='bi-pen'></i></button></div>" +
                        "<div class='col-3'><button class='btn btn-danger' id='delete' data-bs-target=\"#productDeleteModal\" data-bs-toggle=\"modal\"><i class='bi-trash' ></i></button></div></div>"
                }
            }
        ]
    })

    $('#saveProduct').click(function (){
        let name = document.getElementById('name').value;
        let price =document.getElementById('price').value;
        let description = document.getElementById('description').value;
        let photo = document.getElementById('photo').value;
        let categoyId = Number.parseInt(document.getElementById('categoryId').value);
        if (name.trim().length === 0){
            return alert('nomini kiritimadingiz')
        }
        if (price.length === 0){
            return alert('narxini kiritmadingiz')
        }
        if (description.trim().length === 0){
            return alert('tavsilot kiritmadingiz')
        }
        if (photo.trim().length === 0){
            return  alert('rasm urlni kiritmadingiz')
        }
        if (categoyId.length === 0){
            return alert('category Idsini kiritlmadi')
        }
        let obj = {name, photo, price, description, categoryId: categoyId}

        $.ajax({
            url: '/dashboard/product',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(obj)
        })
        alert('mahsulot qoshildi')
        window.location.reload()
    })

    $(productTable.table().body).on('click', '#delete', function () {
        let data = productTable.row($(this).parents('tr')).data();
        id = data.id;
    })

    $(productTable.table().body).on('click', '#edit', function () {
        let data = productTable.row($(this).parents('tr')).data();
        id = data.id;
    })

    $('#deleteProduct').click(function (){
        $.ajax({
            url: '/dashboard/product/' + id,
            method: 'DELETE'
        })
        alert('ochirildi')
        window.location.reload()
    })

    $('#editProduct').click(function (){
        let name = document.getElementById('editpName').value;
        let price = document.getElementById('editPrice').value;
        let description = document.getElementById('editpDesc').value;
        let photo = document.getElementById('editpPhoto').value;
        if (name.trim().length === 0){
            return alert('nomini kiritimadingiz')
        }
        if (price.length === 0){
            return alert('narxini kiritmadingiz')
        }
        if (description.trim().length === 0){
            return alert('tavsilot kiritmadingiz')
        }
        if (photo.trim().length === 0){
            return  alert('rasm urlni kiritmadingiz')
        }
        let obj  = {name, photo, price, description}
        $.ajax({
            url: '/dashboard/product/' + id,
            method: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(obj)
        })
        alert("taxrirlandi")
        window.location.reload()
    })
})