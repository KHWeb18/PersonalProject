import Vue from 'vue';

Vue.filter("timestampFilter", (value) => {

  if(value === null || value === '' || value === undefined){
    return value;
  }
  return value.replaceAll("T", "");
});
