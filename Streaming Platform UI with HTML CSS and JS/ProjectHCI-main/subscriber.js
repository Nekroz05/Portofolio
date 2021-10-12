// localStorage['subs'] = 'notsubscribed'

function subsCheck(){
    if(localStorage['subs'] == 'subscribed'){
        document.getElementById('SubscribeNowDiv').style.display = 'none'
        document.getElementById('SubscribeNowP').style.display = 'block'
        document.getElementById('SubscribeNowP').style.margin = '0 0 0 1vw'
    }
}
