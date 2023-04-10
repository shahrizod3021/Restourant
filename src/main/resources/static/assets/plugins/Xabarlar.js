$(document).ready(function () {
    let xabarId = '';
    $.ajax({
        url: '/dashboard/xabarlar/list',
        method: 'GET',
        success: function (xabarlar) {
            $.each(xabarlar, function (tr, xabar) {
                $('#xabarlar').append(
                    `
                    <div class="col">
      <div class="card h-100 border-info" >
        <div class="card-body ">
        <div class="d-flex">
          <h5 class="card-title">${xabar.name} tomondan</h5>
          <button onclick="${xabarId = xabar.id}" class="btn" style="margin-left: 25%; float: right" data-bs-target="#xabarDeleteModal" data-bs-toggle="modal"><i class="bi-trash"></i></button>
</div>
          <p class="card-text">Ushbu xabar egasining telefon raqami:<br>+998 ${xabar.phoneNumbers}</p>
<p>
  <button class="btn btn-info" type="button" data-bs-toggle="collapse" data-bs-target="#${xabar.id}" aria-expanded="false" aria-controls="collapseWidthExample" >
    Xabarni ko'rish
  </button>
</p>
<div style="min-height: 100px;">
  <div class="collapse collapse-horizontal" id="${xabar.id}">
    <div class="card card-body" id="message" style="width: 300px;">
        ${xabar.message}
    </div>
  </div>
</div>
        </div>
      </div>
    </div>
                    `
                )
            })
        }
    })



//     $('#systemSearch').click(function () {
//         localStorage.removeItem("notification")
//         let name = document.getElementById('searchingItem').value
//         localStorage.setItem("searchingItem",name)
//         $.ajax({
//             url: '/dashboard/xabarlar/0009792:2006:30:11/shahrizod/' + localStorage.getItem("searchingItem"),
//             method: 'GET',
//             success: function (xabarlar) {
//                 if (xabarlar.length === 0){
//                    alert("qidiruv natijasida hech narsa topilamdi")
//                 }else {
//                     $.each(xabarlar, function (tr, xabar) {
//                         $('#xabarlar').append(
//                             `
//                    <div class="col">
//       <div class="card h-100 border-info" >
//         <div class="card-body ">
//         <div class="d-flex">
//           <h5 class="card-title">${xabar.name} tomondan</h5>
//           <button onclick="${xabarId = xabar.id}" class="btn" style="margin-left: 25%; float: right" data-bs-target="#xabarDeleteModal" data-bs-toggle="modal"><i class="bi-trash"></i></button>
// </div>
//           <p class="card-text">Ushbu xabar egasining telefon raqami:<br>+998 ${xabar.phoneNumbers}</p>
// <p>
//   <button class="btn btn-info" type="button" data-bs-toggle="collapse" data-bs-target="#${xabar.id}" aria-expanded="false" aria-controls="collapseWidthExample" >
//     Xabarni ko'rish
//   </button>
// </p>
// <div style="min-height: 100px;">
//   <div class="collapse collapse-horizontal" id="${xabar.id}">
//     <div class="card card-body" id="message" style="width: 300px;">
//         ${xabar.message}
//     </div>
//   </div>
// </div>
//         </div>
//       </div>
//     </div>
//                     `
//                         )
//                     })
//                 }
//             }
//         })
//     })

    $('#sendMessage').click(function () {
        let name = document.getElementById('name').value;
        let phoneNumbers = document.getElementById('phonenumber').value;
        let mesage = document.getElementById('message').value;
        if (name.trim().length === 0) {
            return alert("Ismingizni kiritmadingiz")
        }
        if (phoneNumbers.length === 0) {
            return alert("telefon raqamingizni kiritmadingiz")
        }
        if (phoneNumbers.length !== 9) {
            return alert("Telefon raqam uzunligi 9ta bo'lishi shart")
        }
        if (mesage.trim().length === 0) {
            return alert("biror bir habar yozing")
        }
        let obj = {name, message: mesage, phoneNumbers}
        $.ajax({
            url: '/dashboard/xabarlar/send',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(obj)
        })
        alert("Xabar yuborildi")
        window.location.reload()
    })

    $('#deleteAlert').click(function () {
        $.ajax({
            url: '/dashboard/xabarlar/' + xabarId,
            method: 'DELETE'
        })
        alert("Xabar o'chirildi")
        window.location.reload()
    })
})