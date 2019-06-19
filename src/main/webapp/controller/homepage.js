function getUserFilms() {

    let ID = sessionStorage.getItem('ID');
    const container = document.getElementById('displayDetails');
    makeRequest("GET", path + `user/getAUser/${ID}`)
        .then((data) => {

            const containerDiv = document.getElementById('favFilmsDiv');
            let tableHeading = document.createElement('h1');
            tableHeading.id = "tableHeading";
            tableHeading.innerHTML = "Your favourite films";
            containerDiv.appendChild(tableHeading);
            if (document.contains(document.getElementById("table1"))) {
                containerDiv.removeChild(document.getElementById("table1"));
                containerDiv.removeChild(document.getElementById("tableHeading"));
            }
            let container = document.createElement('table');
            container.id = "table1";
            containerDiv.appendChild(container);
            let tableHeadingTitle = document.createElement('th');
            tableHeadingTitle.innerHTML = "Tilte";
            container.appendChild(tableHeadingTitle);
            let tableHeadingRemoveFilm = document.createElement('th');
            tableHeadingRemoveFilm.innerHTML = "Remove Film";
            container.appendChild(tableHeadingRemoveFilm);

            for (let i = 0; i < data.films.length; i++) {
                let myRow = document.createElement('tr');
                myRow.id = "row" + i;
                container.appendChild(myRow);

                let myTitle = document.createElement('td');
                myTitle.innerHTML = String(data.films[i].title);
                myRow.appendChild(myTitle);

                let myRemoveFilm = document.createElement('td');
                myRow.appendChild(myRemoveFilm);
                let removeFilmbtn = document.createElement('input');
                removeFilmbtn.type = "button";
                removeFilmbtn.className = "btn btn-primary";
                removeFilmbtn.value = "Remove Film";
                removeFilmbtn.onclick = function removeFilm() {

                };
                myRemoveFilm.appendChild(removeFilmbtn);

            }
            console.log(data);
        })
        .catch((error) => console.log(error.message));
    return false;


}

function getAllFilms() {

    let ID = sessionStorage.getItem('ID');
    const container = document.getElementById('displayDetails');
    makeRequest("GET", path + "film/getAllFilms")
        .then((data) => {

            const containerDiv2 = document.getElementById('AllFilmsDiv');
            let tableHeading = document.createElement('h1');
            tableHeading.id = "tableHeading2";
            tableHeading.innerHTML = "Disney films";
            containerDiv2.appendChild(tableHeading);
            if (document.contains(document.getElementById("table2"))) {
                containerDiv2.removeChild(document.getElementById("table2"));
                containerDiv2.removeChild(document.getElementById("tableHeading2"));
            }
            let container = document.createElement('table');
            container.id = "table2";
            containerDiv2.appendChild(container);
            let tableHeadingTitle = document.createElement('th');
            tableHeadingTitle.innerHTML = "Tilte";
            container.appendChild(tableHeadingTitle);
            let tableHeadingRemoveFilm = document.createElement('th');
            tableHeadingRemoveFilm.innerHTML = "Add a film";
            container.appendChild(tableHeadingRemoveFilm);

            for (let i = 0; i < data.length; i++) {
                let myRow = document.createElement('tr');
                myRow.id = "row" + i;
                container.appendChild(myRow);

                let myTitle = document.createElement('td');
                myTitle.innerHTML = data[i].title;
                myRow.appendChild(myTitle);

                let myAddFilm = document.createElement('td');
                myRow.appendChild(myAddFilm);
                let addFilmbtn = document.createElement('input');
                addFilmbtn.type = "button";
                addFilmbtn.className = "btn btn-primary";
                addFilmbtn.value = "Add Film";
                let Film_ID = data[i].id;

                addFilmbtn.onclick = (function () {
                    return function () {
                        addFilm(ID, Film_ID);
                    }
                })(data[i]["id"]);
                myAddFilm.appendChild(addFilmbtn);

            }
            console.log(data);
        })
        .catch((error) => console.log(error.message));
    return false;

}

function addFilm(ID, Film_ID) {
    makeRequest("POST", path + `user/addFavFilm/${ID}/${Film_ID}`)
        .then((data) => {
            console.log(data);
        })
        .catch((error) => {
            console.log(error.message)
            document.getElementById("AddFilmResponce").value = "you have already added this film";
        });
    return false;
}
