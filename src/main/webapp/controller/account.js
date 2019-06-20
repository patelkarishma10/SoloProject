function getAccountDetails() {
    let ID = sessionStorage.getItem('ID');
    makeRequest("GET", path + `user/getAUser/${ID}`)
        .then((data) => {
            const username = data.username;
            const email = data.email;
            const password = data.password;
            const ID = data.id;

            document.getElementById("updateId").value = ID;
            document.getElementById("updateEmail").value = email;
            document.getElementById("updateUsername").value = username;
            document.getElementById("updatePassword").value = password;


            document.getElementById("tableId").innerHTML = ID;
            document.getElementById("tableEmail").innerHTML = email;
            document.getElementById("tableUsername").innerHTML = username;

        })
        .catch((error) => console.log(error.message));
    return false;
}

function confirmDelete() {
    let result = confirm("Are you sure you want to delete your account?");
    if (result) {
        deleteAccount();
    }
}

function deleteAccount() {
    let ID = sessionStorage.getItem('ID');
    makeRequest("DELETE", path + `user/deleteUser/${ID}`)
        .then((data) => {
            sessionStorage.clear();
            window.location.href = 'index.html';
        })
        .catch((error) => console.log(error.message));
    return false;
}

function updateAccount() {
    let id = Number(document.getElementById("updateId").value);
    let updateAcc = {
        username: document.getElementById("updateUsername").value,
        password: document.getElementById("updatePassword").value,
        email: document.getElementById("updateEmail").value
    };
    makeRequest("PUT", path + `user/updateUser/${id}`, updateAcc)
        .then((data) => {
            window.location.href = "account.html"
        }).catch((error) => console.log(error.message));

    return false;
}
