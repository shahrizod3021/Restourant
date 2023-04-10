$(document).ready(function (){
    $.ajax({
        url: '/main/000:97:92/shahrizod/zakaz',
        method: 'GET',
        success: function (zakazlar){
            $.each(zakazlar, function (tr, zakaz){
                $('#zakazlar').append(
                    `
                        <div class="col">
      <div class="card h-100 border-info">
        <div class="card-body ">
          <h5 class="text-primary">Telefon raqam: ${zakaz.oluvchi.phoneNumber}</h5><br>
          <h5 class="text-danger" style="font-style: italic">Mahsulot nomi: ${zakaz.mahsulot.name}</h5><br>
          <h5 class="text-primary">Buyurtma soni: ${zakaz.nechta}</h5><br>
          <h5 class="text-primary" style="font-style: italic">Umumiy summa: ${zakaz.price} so'm</h5><br>
          <h5 class="text-info">Vaqt: ${zakaz.zakazVaqti}</h5>
        </div>
      </div>
    </div>
                    `
                )
            })
        }
    })
})