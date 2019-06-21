function getUserFilms() {

    let ID = sessionStorage.getItem('ID');
    makeRequest("GET", path + `user/getAUser/${ID}`)
        .then((data) => {

            const containerDiv = document.getElementById('favFilmsDiv');
            let tableHeading = document.createElement('h2');
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
                let FilmID = data.films[i].id;

                removeFilmbtn.onclick = function () {
                    removeFilm(ID, FilmID);
                };
                myRemoveFilm.appendChild(removeFilmbtn);

            }
        })
        .catch((error) => console.log(error.message));
    return false;


}

function getAllFilms() {

    let ID = sessionStorage.getItem('ID');
    makeRequest("GET", path + "film/getAllFilms")
        .then((data) => {

            const containerDiv2 = document.getElementById('AllFilmsDiv');
            let tableHeading = document.createElement('h2');
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
                let FilmID = data[i].id;

                addFilmbtn.onclick = function () {
                    addFilm(ID, FilmID);
                }

                myAddFilm.appendChild(addFilmbtn);

            }
        })
        .catch((error) => console.log(error.message));
    return false;

}

function getAllCharacters() {

    //let ID = sessionStorage.getItem('ID');
    makeRequest("GET", path + "character/getAllCharacters")
        .then((data) => {

            const containerDiv3 = document.getElementById('AllCharactersDiv');
            let tableHeading = document.createElement('h2');
            tableHeading.id = "tableHeading3";
            tableHeading.innerHTML = "Disney characters";
            containerDiv3.appendChild(tableHeading);
            if (document.contains(document.getElementById("table3"))) {
                containerDiv3.removeChild(document.getElementById("table3"));
                containerDiv3.removeChild(document.getElementById("tableHeading3"));
            }
            let container = document.createElement('table');
            container.id = "table3";
            containerDiv3.appendChild(container);
            let tableHeadingTitle = document.createElement('th');
            tableHeadingTitle.innerHTML = "Name";
            container.appendChild(tableHeadingTitle);
            let tableHeadingRemoveCharacter = document.createElement('th');
            tableHeadingRemoveCharacter.innerHTML = "Delete this character";
            container.appendChild(tableHeadingRemoveCharacter);

            for (let i = 0; i < data.length; i++) {
                let myRow = document.createElement('tr');
                myRow.id = "row" + i;
                container.appendChild(myRow);

                let myName = document.createElement('td');
                myName.innerHTML = data[i].name;
                myRow.appendChild(myName);

                let myRemoveCharacter = document.createElement('td');
                myRow.appendChild(myRemoveCharacter);
                let removeCharbtn = document.createElement('input');
                removeCharbtn.type = "button";
                removeCharbtn.className = "btn btn-primary";
                removeCharbtn.value = "Delete Character";
                //let FilmID = data[i].id;

                removeCharbtn.onclick = function () {

                }

                myRemoveCharacter.appendChild(removeCharbtn);

            }
        })
        .catch((error) => console.log(error.message));
    return false;

}

function addFilm(ID, FilmID) {
    makeRequest("POST", path + `user/addFavFilm/${ID}/${FilmID}`)
        .then((data) => {
            getUserFilms();
        })
        .catch((error) => {
            console.log(error.message)
        });
    return false;
}

function removeFilm(ID, FilmID) {

    makeRequest("DELETE", path + `user/deleteFavFilm/${ID}/${FilmID}`)
        .then((data) => {
            getUserFilms();
        })
        .catch((error) => {
            console.log(error.message)
        });
    return false;
}
