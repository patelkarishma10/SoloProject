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

function createCharacter() {

    let newChar = {
        name: document.getElementById("charName").value,
    };
    makeRequest("POST", path + "character/createCharacter", newChar)
        .then((data) => {
            getAllCharacters();
        })
        .catch((error) => console.log(error.message));
    return false;
}
