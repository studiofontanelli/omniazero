<style>

body {
    padding-bottom: 50px;
}

.avanzamento-box {
    background-color: #009600;
    color: #ffffff;
    border: 2px solid;
    border-radius: 3px;
    padding-left: 10px;
    margin-bottom: 10px;
}

.alert-minimalist {
	background-color: white;
    border-color: rgba(149, 149, 149, 0.6);
    border-radius: 3px;
    color: rgb(149, 149, 149);
    padding: 10px;
    min-width: 300px;
    cursor: pointer;
}
.alert-minimalist > [data-notify="icon"] {
	height: 30px;
	margin-right: 12px;
}
.alert-minimalist > [data-notify="title"] {
	color: rgb(51, 51, 51);
	display: block;
	font-weight: bold;
	margin-bottom: 5px;
}
.alert-minimalist > [data-notify="message"] {
	font-size: 100%;
}

.notificaBox {
	cursor: pointer;
}

.notificaBox-list {
	margin-bottom: 5px;
}

.notifica-non-letta-list {
	background-color: #f5fdf2;
}

.notifica-letta-list {
	background-color: #f5f5f5;
	opacity: 0.6;
}

.notificaBox-one {
	background-color: white;
    border-color: rgba(149, 149, 149, 0.6);
    border-radius: 3px;
    color: rgb(149, 149, 149);
}
.notifica-non-letta-one {
}
.notifica-letta-one {
}

/*Modifiche 20160919*/
body {
	background: #C6C6C6;
}

.container-grey {
	background: #E7E8EA;
}

#inserimentoIniziativaForm > fieldset > .row {
	margin-left: 0;
	margin-right: 0;
}

legend {
    color: #084E82;
    font-size: 25px;
	border-bottom: 1px solid #C5C6CA;
}

.form-control {
    border-radius: 0;
    box-shadow: none;
}

select {
    -webkit-appearance: none; /*webkit border-radius override*/
}
    
.form-group label {
    font-weight: normal;
    color: #3f6b88;
}

.form-group .input-group {
    padding: 0 15px;
}

.input-group-addon {
    border-radius: 0;
}

/*Footer*/
footer {
    background: #0153A9;
    color: #fff;
}

footer a, footer a:focus, footer a:active {
	color: #fff;
	font-size: 12px;
}

footer a:hover {
	color: #b1b1b1;
	text-decoration: none;
}

.footer-logo {
	display: inline-block;
    width: 200px;
    margin-top: 20px;
    height: 35px;
    background-size: 100%;
    background-repeat: no-repeat;
}

.sistemapiemonte-logo {
	background-image: url("/scadeweb/img/banner-sistemapiemonte.jpg");
}

.regionepiemonte-logo {
	background-image: url("/scadeweb/img/logoregs.png");
	width: 110px;
	margin-top: 14px;
}

.footer-links {
	margin-top: 18px;
	margin-bottom: 6px;
}

.text-right .dropdown-menu {
	left: inherit;
	right: 0;	/*save button align fix*/
}

/*Navbar*/
.container-grey .navbar-default {
    background: #0153A9;
    border: none;
}

.container-grey .navbar-default > .container {
    background: #13A4DB;
}

.navbar-default .navbar-brand,
.navbar-default .navbar-brand:focus,
.navbar-default .navbar-brand:active {
	color: #fff;
	cursor: pointer;
	font-weight: 100;
    text-transform: uppercase;
}

.navbar-default .navbar-brand span {
	font-weight: bold;
}

.navbar-default .navbar-nav>li>a,
.navbar-default .navbar-nav>li>a:focus, 
.navbar-default .navbar-nav>li>a:active  {
    color: #fff;
}

.navbar-default .navbar-brand:hover,
.navbar-default .navbar-nav>li>a:hover {
    color: #555;
}

.navbar-default .navbar-toggle .icon-bar {
    background-color: #fff;
}

.navbar-default .navbar-nav>.open>a, .navbar-default .navbar-nav>.open>a:focus, .navbar-default .navbar-nav>.open>a:hover {
    background: #fff;
}

.navbar-default ul.dropdown-menu {
    border: none;
    border-radius: 0;
    top: 49px;
}

/*Bottoni*/
.btn-primary {
    background-color: #0C7094;
}

.btn-primary:hover, .btn-primary:active, .btn-primary:focus {
    background-color: #0a5d7b;
    border-color: #2e6da4;
}

.btn {
	border-radius: 0;
    text-transform: uppercase;
}

.dropdown-toggle span.glyphicon.glyphicon-user,
.dropdown-toggle:focus span.glyphicon.glyphicon-user,
.dropdown-toggle:active span.glyphicon.glyphicon-user {
    border-radius: 15px;
    padding: 3px;
    font-size: 20px;
    float: left;
    top: -5px;
    right: 7px;
    border: 2px solid #fff;
}

.dropdown-toggle:hover span.glyphicon.glyphicon-user,
.open .dropdown-toggle span.glyphicon.glyphicon-user,
.open .dropdown-toggle:hover span.glyphicon.glyphicon-user,
.open .dropdown-toggle:active span.glyphicon.glyphicon-user,
.open .dropdown-toggle:focus span.glyphicon.glyphicon-user {
    border: 2px solid #555;
}

.btn-default, .btn-default:hover {
    color: #0F7291;
    background-color: #fff;
    border-color: #0A7096;
}

.btn-default:hover {
    color: #fff;
    background-color: #0f7291;
}

.form-group input[type=file] {
	background: #BCD0D9;
    color: #3B607A;
    padding: 9px;
    position: relative;
    line-height: 0;
    width: 95%;
}

select.form-control {
    background-image: url(/scadeweb/img/path.png);
    background-repeat: no-repeat;
    background-position: 97%;
    background-size: 15px;
}

.row-margin-bottom {
	margin-bottom: 30px;
}

span.input-group-addon.glyphicon.glyphicon-search,
span.input-group-addon.glyphicon.glyphicon-remove {
	top: 0;
}

/*Modali*/
.modal-title {
    color: #094C76;
    font-weight: normal;
}

.modal-content {
    background: #E7E8EA;
    padding: 0 20px;
    border: none;
    border-radius: 0;
}

.modal-header {
    border-bottom: 1px solid #C5C6CA;    
}

.modal-header, .modal-body, .modal-footer {
	padding-left: 0;
    padding-right: 0;
}

.modal-footer {
    border-top: 1px solid #C5C6CA;
}

.disabled-well {
    background: none;
    border: none;
    box-shadow: none;
}

#directives-calendar .well {
	padding-top: 0;
}

.modal-header .close {
    color: #fff;
    background-color: #15A3DD;
    border-radius: 15px;
    opacity: 0.8;
    filter: alpha(opacity=80);
    width: 18px;
    height: 0;
    font-size: 15px;
    font-weight: normal;
    margin-top: 5px;
    text-shadow: none;
    padding-bottom: 18px;
}

.modal-header .close:hover {
    opacity: 1;
    filter: alpha(opacity=100);
}

/*Errori*/
.gen-error {
    background: #F6E6E7;
    border: 2px solid #ED4936;
    padding: 7px;
    text-align: center;
    margin-top: 2px;
}

.gen-error font {
    color: #D13D35;
}

.input-group.has-error {
    margin-bottom: 42px;
}

.input-group-addon + .gen-error {
    position: absolute;
    left: 15px;
    top: 34px;
    width: 90%;
}

/*Agenda*/
.fc-view-container {
	background: #f9f9f9;
}

.fc-day-grid-container.fc-scroller {
	height: auto !important; /*angular override?*/
}

.fc-unthemed th, .fc-unthemed td, .fc-unthemed hr, .fc-unthemed thead, .fc-unthemed tbody, .fc-unthemed .fc-row, .fc-unthemed .fc-popover {
    border-color: #c7c7c7;
    cursor: pointer;
}

.fc-basic-view tbody .fc-row {
    min-height: 130px;
}

.fc td.fc-widget-header, .fc td div.fc-widget-header {
    border-color: transparent;
    border-bottom-color: #c7c7c7;
    background: #e7e8ea;
}

th.fc-day-header {
    border: none;
    text-align: right;
    font-weight: normal;
    color: #084B75;
    padding-right: 6px;
	text-transform: lowercase;
}

.fc-day-grid-event {
    margin: 2px 5px;
    border-radius: 0;
    padding: 2px;
}

button.btn.btn-calendar, button.btn.btn-calendar:active,
button.btn.btn-calendar:focus, button.fc-button.fc-today-button {
    background: #fff;
    border: 1px solid #C5C6C8;
    text-transform: lowercase;
    color: #787879;
    border-radius: 0;
}

button.btn.btn-calendar:hover {
    background: #f9f9f9;
}

.calendar .fc-left h2 {
    color: #074D71;
}

.calendar .fc-toolbar .fc-right {
    float: left;
    margin-left: 50px;
}

button.fc-prev-button.fc-button, button.fc-next-button.fc-button {
    background: #fff;
    border-radius: 0;
    border: 1px solid #C5C6C8;
    color: #13A0E0;
    outline: none;
}

.fc-unthemed .fc-today {
    background: none;
}

.fc-ltr .fc-basic-view .fc-day-number {
    font-weight: bold;
    padding-right: 5px;
    color: #2B5676;    
}

.fc-ltr .fc-basic-view .fc-day-number.fc-today {
    box-shadow: inset -40px 0px 15px -15px #255677;
    color: #fff;
}

.fc-scroller {
    overflow: hidden;
}

.fc-event-container a {
    color: #000;
    background-color: #fff !important;
    border-right-width: 10px;
    padding: 5px 0px 5px 5px;
    border-bottom-color: #C5C5C7 !important;
    border-top-color: #C5C5C7!important;
    border-left-color: #C5C5C7 !important;
}

.fc-event-container a .fc-content{
	white-space: inherit;
}

.fc-event, .fc-event:hover, .ui-widget .fc-event {
    color: #000;
    background-color: #e7e8ea !important;
}

#vista-lista-placeholder table {
    border: 1px solid #C6C6C8;
}

ricerca-avanzata a, ricerca-avanzata a:hover {
    cursor: pointer;
    text-decoration: none;
}

ricerca-avanzata > div,
ricerca-aggregata > div {
    position: absolute !important; /*bootstrap relative override*/
    z-index: 999;
    padding: 0 !important;
}

ricerca-aggregata > div {
    top: 90px;
}

ricerca-avanzata > div > .panel, ricerca-aggregata > div > .panel {
    box-shadow: 0px 10px 27px 2px grey;
    border: none;
    border-radius: 0;
    padding: 6px;
	background: #f9f9f9;
}

ricerca-aggregata > div .panel-body, ricerca-aggregata > div > .panel {
    padding: 0;
}

ricerca-aggregata > div .panel-body > table {
    margin-bottom: 0;
}

ricerca-aggregata > div .panel-body > table td.ng-binding {
	color: #255A7A;
}

ricerca-aggregata > div .panel-body > table > tbody > tr > td {
	padding-top: 0;
	padding-bottom: 0;
    vertical-align: middle;
}

ricerca-aggregata > div .panel-body > table > tbody > tr > td .checkbox {
	text-align: center;
}

ricerca-aggregata > div .panel-body > table > tbody > tr > td .checkbox input {
	margin: 6px 0 0 -16px;
}

ricerca-aggregata > div .panel-body > table > tbody > tr > td:first-child {
	background: #C9C9CB;
}

ricerca-aggregata > div .panel-body > table > tbody > tr > td:last-child {
	background: #13A4DB;
}

/*Tabella ricerca*/
.calendar td.palegrey {
    background: #fff;
}

.calendar table tbody tr:first-child td:not(.grey) {
    font-weight: bold;
    color: #005072;
}

.calendar table tbody tr:first-child td .progress {
    border-radius: 0;
}

vista-lista-sub-item-details .panel {
    margin: 0 25px;
    border: none !important;
    background-color: transparent !important;
    box-shadow: none;
}

vista-lista-sub-item-details .panel table {
    border: 1px solid #097194;
    margin-bottom: 0;
}

vista-lista-sub-item-details .panel td.palegrey {
    background-color: #EDF8FA !important;
}

vista-lista-item .row {
	background: #c6c6c6;
}

/*Responsive*/
@media (max-width: 1199px) {
  footer .row > div {
    text-align: center;
  }
}
@media (max-width: 767px) {
	.navbar-default .navbar-nav .open .dropdown-menu>li>a {
	    color: #fff;
	}
}


</style>