$(document).ready(function (){
    $.ajax({
        url: '/dashboard/category/list',
        method: 'GET',
        success: function (categories) {
            $('#card').append(`
                    ${categories.length} <br>
                    <a href="https://restaurant-shahrizod.herokuapp.com/dashboard/category/categoryList/0009792:2006:30:11/shahrizod" class="btn btn-outline-primary">Categoryga o'tish</a>
                  `)
        }
    })




$.ajax({
    url: '/dashboard/product/list',
    method: 'GET',
    success: function (products){
        $('#card1').append(`
            ${products.length} <br>
            <a href="https://restaurant-shahrizod.herokuapp.com/dashboard/product/0009792:2006:30:11/shahrizod" class="btn btn-outline-danger">Productga o'tish</a>
        `)
    }
})

    $.ajax({
        url: '/dashboard/aware/list',
        method: 'GET',
        success: function (aware){
            $('#card2').append(`
                ${aware.length} <br>
                            <a href="https://restaurant-shahrizod.herokuapp.com/dashboard/aware/awareList/0009792:2006:30:11/shahrizod" class="btn btn-outline-warning">Awarega o'tish</a>
            `)
        }
    })


    $.ajax({
        url: '/dashboard/xabarlar/list',
        method: 'GET',
        success: function (xabarlar){
            $('#card3').append(`
                ${xabarlar.length} <br>
                            <a href="https://restaurant-shahrizod.herokuapp.com/dashboard/xabarlar/0009792:2006:30:11/shahrizod" class="btn btn-outline-success">Xabarlarni ko'rish</a>
            `)
        }
    })

    $.ajax({
        url: '/dashboard/category/list',
        method: 'GET',
        success: function (categories){
            $('#p1').append(
                `
                            <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-label="Animated striped example" aria-valuenow="${categories.length}" aria-valuemin="0" aria-valuemax="${categories.length}" style="width: ${categories.length}%"></div>
                `
            )
            $('#jami').append(
                `
                            <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-label="Animated striped example" aria-valuenow="${categories.length}" aria-valuemin="0" aria-valuemax="${categories.length}" style="width: ${categories.length}%"></div>
                `
            )
            $('#c1').append(
                `
                    ${categories.length}
                `
            )
        }
    })
    $.ajax({
        url: '/dashboard/product/list',
        method: 'GET',
        success: function (products){
            $('#p2').append(
                `
                            <div class="progress-bar progress-bar-striped progress-bar-animated bg-danger" role="progressbar" aria-label="Animated striped example" aria-valuenow="${products.length}" aria-valuemin="0" aria-valuemax="${products.length}" style="width: ${products.length}%"></div>
                `
            )
            $('#jami').append(
                `
                            <div class="progress-bar progress-bar-striped progress-bar-animated bg-danger" role="progressbar" aria-label="Animated striped example" aria-valuenow="${products.length}" aria-valuemin="0" aria-valuemax="${products.length}" style="width: ${products.length}%"></div>
                `
            )
            $('#pr1').append(
                `
                    ${products.length}
                `
            )
        }
    })
    $.ajax({
        url: '/dashboard/aware/list',
        method: 'GET',
        success: function (awares){
            $('#p3').append(
                `
                            <div class="progress-bar progress-bar-striped progress-bar-animated bg-warning" role="progressbar" aria-label="Animated striped example" aria-valuenow="${awares.length}" aria-valuemin="0" aria-valuemax="${awares.length}" style="width: ${awares.length}%"></div>
                `
            )
            $('#jami').append(
                `
                            <div class="progress-bar progress-bar-striped progress-bar-animated bg-warning" role="progressbar" aria-label="Animated striped example" aria-valuenow="${awares.length}" aria-valuemin="0" aria-valuemax="${awares.length}" style="width: ${awares.length}%"></div>
                `
            )
            $('#aw1').append(
                `
                    ${awares.length}
                `
            )
        }
    })
    $.ajax({
        url: '/dashboard/xabarlar/list',
        method: 'GET',
        success: function (xabarlar){
            $('#p4').append(
                `
                            <div class="progress-bar progress-bar-striped progress-bar-animated bg-success" role="progressbar" aria-label="Animated striped example" aria-valuenow="${xabarlar.length}" aria-valuemin="0" aria-valuemax="${xabarlar.length}" style="width: ${xabarlar.length}%"></div>
                `
            )
            $('#jami').append(
                `
                            <div class="progress-bar progress-bar-striped progress-bar-animated bg-success" role="progressbar" aria-label="Animated striped example" aria-valuenow="${xabarlar.length}" aria-valuemin="0" aria-valuemax="${xabarlar.length}" style="width: ${xabarlar.length}%"></div>
                `
            )
            $('#us1').append(
                `
                    ${xabarlar.length}
                `
            )
        }
    })
})
