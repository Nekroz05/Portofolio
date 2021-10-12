const form = document.getElementById("form")
    const username = document.getElementById("inputname");
    const email = document.getElementById("inputemail");
    const pass = document.getElementById("inputpass");
    const passconf = document.getElementById("inputpassconf");
    const phone = document.getElementById("inputphone");
    const country = document.getElementById("inputcountry");
    var error = 0

    form.addEventListener('submit', e => {
        e.preventDefault();
        
        checkInputs();
    });

    function checkInputs() {
        error = 0;
        const nameValue = username.value
        const emailValue = email.value
        const passValue = pass.value
        const passconfValue = passconf.value
        const phoneValue = phone.value
        const countryValue = country.value
        
        if(nameValue === '') {
            setErrorFor(inputname, 'Username cannot be blank');
            error = 1;
        } else {
            setSuccessFor(inputname);
        }
        
        if(emailValue === '') {
            setErrorFor(inputemail, 'Email cannot be blank');
            error = 1;
        } else if (!isEmail(emailValue)) {
            setErrorFor(inputemail, 'Not a valid email');
            error = 1;
        } else {
            setSuccessFor(inputemail);
        }
        
        if(passValue === '') {
            setErrorFor(inputpass, 'Password cannot be blank');
            error = 1;
        } else {
            setSuccessFor(inputpass);
        }
        
        if(passconfValue === '') {
            setErrorFor(inputpassconf, 'Password2 cannot be blank');
            error = 1;
        } else if(passconfValue !== passValue) {
            setErrorFor(inputpassconf, 'Passwords does not match');
            error = 1;
        } else{
            setSuccessFor(inputpassconf);
        }

        if(phoneValue === '') {
            setErrorFor(inputphone, 'PhoneNumber cannot be blank');
            error = 1;
        } else {
            setSuccessFor(inputphone);
        }

        if(countryValue === '') {
            setErrorFor(inputcountry, 'Country cannot be blank');
            error = 1;
        } else {
            setSuccessFor(inputcountry);
        }

        if(error==0){
            localStorage['subs'] = 'subscribed'
            location.replace('../homepage/homepage-login.html')
            alert('Congratulation You have Subscribed!')
        }
    }

    function setErrorFor(input, message) {
        const formControl = input.parentElement;
        const small = formControl.querySelector('small');
        formControl.className = 'form-row error';
        small.innerText = message;
    }
    
    function setSuccessFor(input) {
        const formControl = input.parentElement;
        formControl.className = 'form-row success';
    }
        
    function isEmail(email) {
        return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
    }