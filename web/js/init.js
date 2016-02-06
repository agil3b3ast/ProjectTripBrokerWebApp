(function($){
  $(function(){

    $('.button-collapse').sideNav();
    $('.parallax').parallax();

  }); // end of document ready
})(jQuery); // end of jQuery name space


$('select').material_select();
$('.datepicker').pickadate({
  selectMonths: true, // Creates a dropdown to control month
  selectYears: 15 // Creates a dropdown of 15 years to control year
});
//$('.collapsible').collapsible({
//  accordion : true // A setting that changes the collapsible behavior to expandable instead of the default accordion style
//});
$(".dropdown-button").dropdown({
  hover : false,
  alignment: 'left',
  gutter : 100,
  constrain_width: true,
  belowOrigin: true
});

