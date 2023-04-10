$(document).ready(function () {

    $.ajax({
        url: '/dashboard/category/list',
        method: 'GET',
        success: function (categories) {
            $.each(categories, function (tr, category) {
                $('#userCategory').append(
                    `<div class="col">
       <div class="card h-100 ">
        <div class="card-body">
        <img src="${category.photo}" alt="${category.name}" class="card-img-top">
          <h5 class="card-title" style="font-style: italic">${category.name}</h5>
          <p class="card-text" >Active: ${category.active}</p>
          <p class="card-text">Mahsulotlar soni: ${category.mahsulotlar.length}</p>
          <a id="productOfCategory" href="https://restaurant-shahrizod.herokuapp.com/dashboard/product/0009792:2006:30:11/shahrizod/page/${category.id}" onclick="localStorage.setItem('categoryId', ${category.id})" class="btn btn-primary">Mahsulotlarni ko'rish</a>
        </div>
      </div>
    </div>`
                )
            })
        }

    })

    $.ajax({
        url: '/dashboard/category/list',
        method: 'GET',
        success: function (categories) {
            if (categories.length === 0) {
                $('#carusel').append(
                    `
                        <h1 class="text-danger">Hali Categorylar mavjud emas</h1>
                    `
                )
            } else {
                $.each(categories, function (tr, category) {
                    $('#carusel').append(
                        `
                        <div class="carousel-item active" data-bs-interval="10000">
                          <img src="${category.photo}" class="d-block w-100" alt="${category.name}">
                          <div class="carousel-caption d-none d-md-block">
                            <h5 class="text-light" style="font-style: italic; font-size: 50px">${category.name}</h5>
                            <p style="font-size: 25px; color: white">Active: ${category.active}</p>
                          </div>
                        </div>
                    `
                    )
                    $('#carousel-indicators').append(
                        `
                          <button type="button"  data-bs-target="#carouselExampleDark" data-bs-slide-to="${category.id}" class="active"  aria-current="true" aria-label="Slide 1"></button>
                        `
                    )

                })
            }
        }
    })

    $.ajax({
        url: '/dashboard/product/0009792:2006:30:11/shahrizod/' + localStorage.getItem("categoryId"),
        method: 'GET',
        success: function (products) {
            if (products.length === 0) {
                $('#userProduct').append(
                    `
                    <h1>oka hali product mavjud emas...</h1>
                    `
                )
            } else {
                $.each(products, function (tr, product) {
                    $('#userProduct').append(
                        `
                        <div class="col">
                            <div class="card">
                                <img src="${product.photo}" class="card-img-top" alt="${product.name}">
                                    <div class="card-body">
                                         <h3 class="card-title text-info" style="font-style: italic;" >${product.name}</h3> 
                                         <h4 style="font-style: italic; color: gold" class="card-title">${product.price} so'm</h4>
                                         <p class="card-text">${product.description}</p>
                                    <div class="card-footer">
                                        <button class="btn btn-outline-info" id="zakazat" onclick="localStorage.setItem('productId',${product.id})" data-bs-target="#zakazzModal" data-bs-toggle="modal">Zakaz berish</button>
                                    </div>
                                    </div>
                             </div>
                         </div>           
                        `
                    )
                })
            }
        }
    })

    $.ajax({
        url: '/dashboard/product/list',
        method: 'GET',
        success: function (products) {
            $.each(products, function (tr, product) {
                $('#productList').append(
                    `
                        <div class="col">
    <div class="card">
      <img src="${product.photo}" class="card-img-top" alt="${product.name}">
      <div class="card-body">
       <h3 class="card-title text-info" style="font-style: italic">${product.name}</h3>           
       <h4 style="font-style: italic; color: gold" class="card-title">${product.price} so'm</h4>
       <p class="card-text">${product.description}</p>
       <div class="card-footer">
        <button class="btn btn-outline-info" id="zakazat" onclick="localStorage.setItem('productId',${product.id})" data-bs-target="#zakazModal" data-bs-toggle="modal">Zakaz berish</button>
       </div>
      </div>
    </div>
  </div>
                    `
                )
            })
        }
    })

    $('#zakazat').click(function () {
        let phoneNumber = document.getElementById('phoneNumber').value;
        let nechta = document.getElementById('nechta').value;
        if (phoneNumber.trim().length === 0) {
            return alert("telefon raqam kiritmadingiz")
        }
        if (phoneNumber.trim().length !== 9) {
            return alert("telefon raqam uzunligi 9taga teng bo'lishi lozim")
        }
        if (nechta.length === 0) {
            return alert("nechta sotib olishingizni kiritmadingiz")
        }
        let obj = {phoneNumber, nechta}
        $.ajax({
            url: '/main/zakaz/' + localStorage.getItem('productId'),
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(obj)
        })
        alert("Zakazingiz qabul qilidni siz bilan tez orada bo'glanishadi")
        window.location.reload()
    })

    $.ajax({
        url: '/dashboard/aware/list',
        method: 'GET',
        success: function (awares){
            $.each(awares, function (tr, aware){
                if (aware.link.startsWith('http://localhost')){
                    $('#aware').append(
                        `
                    <p>
                        <a href="${aware.link}" style="color: ${aware.color}; text-decoration: none">${aware.name}</a>
                    </p>
                        `
                    )
                }
                if (aware.link.startsWith('https://')){
                    $('#aware1').append(
                        `
                              <p>
                                <a href="${aware.link}" style="color: ${aware.color}; text-decoration: none">${aware.name}</a>
                             </p>
                        `
                    )
                }

            })
        }
    })
})