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
  	<td>${p}</td>
  	<td>${dof}</td>
    <td>${result}</td>
  </tr>
</div>

</body>
</html>
