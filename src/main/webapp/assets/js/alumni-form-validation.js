let alumni_login_form = document.getElementById('alumni-login');

alumni_login_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    console.log(document.getElementById('alumni_login_id').value);
    if(alumni_login_form.checkValidity() === true){
        let response = await fetch('api/alumni/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                alumni_id: document.getElementById('alumni_login_id').value,
                alumni_password: document.getElementById('alumni_password').value
            })
        });
        let result = await response;
        console.log(result);
        if(result['status'] === 200){
            let data = response.json();
            location.href = "alumnidashboard.html";
        }
        // window.location.href = "http://localhost:8080/lab5resthibernate_war/alumnidashboard"
    }
    alumni_login_form.classList.add('was-validated');
});