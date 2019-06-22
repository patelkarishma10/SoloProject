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

            let tableHeadingUpdateCharacter = document.createElement('th');
            tableHeadingUpdateCharacter.innerHTML = "Update this character";
            container.appendChild(tableHeadingUpdateCharacter);

            for (let i = 0; i < data.length; i++) {
                let myRow = document.createElement('tr');
                myRow.id = "row" + i;
                container.appendChild(myRow);

                let myName = document.createElement('td');
                myName.innerHTML = data[i].name;
                myName.id = "name" + i;
                myRow.appendChild(myName);

                let myRemoveCharacter = document.createElement('td');
                myRow.appendChild(myRemoveCharacter);
                let removeCharbtn = document.createElement('input');
                removeCharbtn.type = "button";
                removeCharbtn.className = "btn btn-primary";
                removeCharbtn.value = "Delete Character";
                let CharacterID = data[i].id;
                removeCharbtn.onclick = function () {
                    removeCharacter(CharacterID);
                }
                myRemoveCharacter.appendChild(removeCharbtn);

                let myUpdateCharacter = document.createElement('td');
                myRow.appendChild(myUpdateCharacter);
                let updateCharbtn = document.createElement('input');
                updateCharbtn.type = "button";
                updateCharbtn.className = "btn btn-primary";
                updateCharbtn.value = "Update Character";

                updateCharbtn.onclick = function () {

                    let CharId = CharacterID;
                    const containerDiv4 = document.getElementById('updateform');
                    containerDiv4.className = "formDiv"
                    let tableHeading4 = document.createElement('h2');
                    tableHeading4.id = "tableHeading4";
                    tableHeading4.innerHTML = "Update Disney characters";
                    containerDiv4.appendChild(tableHeading4);
                    if (document.contains(document.getElementById("form1"))) {
                        containerDiv4.removeChild(document.getElementById("form1"));
                        containerDiv4.removeChild(document.getElementById("tableHeading4"));
                    }
                    let container4 = document.createElement('form');
                    container4.id = "form1";
                    containerDiv4.appendChild(container4);
                    let inpultLabel = document.createElement('p');
                    inpultLabel.innerHTML = "name";
                    container4.appendChild(inpultLabel);
                    let inputName = document.createElement('input');
                    inputName.value = "Name";
                    inputName.id = "charName2";
                    container4.appendChild(inputName);
                    let inputSubmit = document.createElement('button');
                    inputSubmit.className = "btn btn-primary"
                    inputSubmit.innerHTML = "Submit";
                    container4.appendChild(inputSubmit);
                    inputSubmit.onclick = function () {
                        let newChar = {
                            name: document.getElementById("charName2").value,
                        };
                        makeRequest("PUT", path + `character/updateCharacter/${CharId}`, newChar)
                            .then((data) => {
                                getAllCharacters();
                            })
                            .catch((error) => console.log(error.message));
                        return false;
                    }
                    return false;
                }
                myUpdateCharacter.appendChild(updateCharbtn);

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

function removeCharacter(CharacterID) {

    makeRequest("DELETE", path + `character/deleteCharacter/${CharacterID}`)
        .then((data) => {
            getAllCharacters();
        })
        .catch((error) => {
            console.log(error.message)
        });
    return false;
}
