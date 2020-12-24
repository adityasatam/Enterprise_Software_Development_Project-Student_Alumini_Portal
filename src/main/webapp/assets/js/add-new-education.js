let add_new_education = document.getElementById('add-education');

add_new_education.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (add_new_education.checkValidity() === true) {
            console.log("degree:", document.getElementById('degree').value);
            let response = await fetch('api/alumni/register_education', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                // first_name: document.getElementById('first_name').value,
                // last_name: document.getElementById('last_name').value,
                degree: document.getElementById('degree').value,
                collegeName: document.getElementById('college_name').value,
                joiningYear: document.getElementById('joining_year').value,
                passingYear: document.getElementById('passing_year').value,
                address: document.getElementById('address').value,
            })
        });
        let result = await response;
        console.log(result);
        if(result['status'] === 200){
            let data = response.json();
            location.href = "alumnieducationedit.html";
        }
    }
    add_new_education.classList.add('was-validated');
});