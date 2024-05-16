function callGetItemApi(zone) {
    $.ajax({
        url: `/SightAPI?zone=${zone}`,
        method: 'GET',
        dataType: 'json',
        success: function(data) {
            updateCard(data);
        },
        error: function(error) {
            console.error('Error', error);
        }
    });
}

function updateCard(data) {
    document.querySelector('.display').innerHTML = "";
    $('.display').append('<div class="dis">');
    for (let i = 0; i < data.length; i++) {

        const cardElement = $('<div class="col-12 col-lg-4"><div className="card"></div></div>');
        let googleMap = "https://www.google.com/maps/place/" + data[i].address;
        let href = "collapseFooter" + i;

        cardElement.append(`<div class="card-header">${data[i].sightName}</div>`);
        cardElement.append(`<div class="card-body">${data[i].zone} </br> ${data[i].category} </br> <button type="button" class="btn btn-secondary btn-block" onclick="location.href='${googleMap}'">地址</button><a class="btn" data-bs-toggle="collapse" href="#${href}">詳細資訊</a></div>`);
        cardElement.append(`<div id="${href}" class="collapse" data-bs-parent="#accordion"><div class="card-footer"><img src="${data[i].photoURL}"></br><p>${data[i].description}</p> </div></div>`)

        $('.dis').append(cardElement);
        $('.dis').addClass("row");
    }

}