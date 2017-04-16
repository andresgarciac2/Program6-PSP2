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
    <th>p</th>
    <th>dof</th>
    <th>x (resultado)</th>
  </tr>
  <tr> 
  	<td>0.20</td>
  	<td>6</td>
    <td>${result1}</td>
  </tr>
    <tr> 
  	<td>0.45</td>
  	<td>15</td>
    <td>${result2}</td>
  </tr>
  </tr>
    <tr> 
  	<td>0.495</td>
  	<td>4</td>
    <td>${result2}</td>
  </tr>
</div>

</body>
</html>
