let add_new_organisation = document.getElementById('add-organisation');

add_new_organisation.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (add_new_organisation.checkValidity() === true) {
        console.log("alumni_org_name:", document.getElementById('alumni_org_name').value);
        let response = await fetch('api/org/register_organisation', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                // first_name: document.getElementById('first_name').value,
                // last_name: document.getElementById('last_name').value,
                alumni_org_name: document.getElementById('alumni_org_name').value,
                alumni_org_position: document.getElementById('alumni_org_position').value,
                alumni_org_joining_date: document.getElementById('alumni_org_joining_date').value,
                alumni_org_leaving_date: document.getElementById('alumni_org_leaving_date').value,
            })
        });
        let result = await response;
        console.log(result);
        if(result['status'] === 200){
            let data = response.json();
            location.href = "alumniorganisationedit.html";
        }
    }
    add_new_organisation.classList.add('was-validated');
});