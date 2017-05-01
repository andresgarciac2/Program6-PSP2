<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
  <style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>

<body>

  <#include "nav.ftl">

<div class="container">

<h1>Presentado por Andres Felipe Garcia Cifuentes</h1>

<table>
  <tr>
    <th>Parameter</th>
    <th>Expected Value</th>
  </tr>
  <tr>
    <th>r x,y</th>
    <th>${r}</th>
  </tr>
  <tr> 
  	<td>r^2</td>
  	<td>${r2}</td>
  </tr>
    <tr> 
  	<td>significance</td>
  	<td>${significance}</td>
  </tr>
    <tr> 
  	<td>B0</td>
  	<td>${b0}</td>
  </tr>
    <tr> 
  	<td>B1</td>
  	<td>${b1}</td>
  </tr>
    <tr> 
  	<td>Yk</td>
  	<td>${yk}</td>
  </tr>
    <tr> 
  	<td>Range</td>
  	<td>${Range}</td>
  </tr>
    <tr> 
  	<td>UPI (70%)-</td>
  	<td>${UPI}</td>
  </tr>
    <tr> 
  	<td>LPI (70%)</td>
  	<td>${LPI}</td>
  </tr>
</div>

</body>
</html>
