Do not mis interpret

<?php echo 'Ending tag excluded';

with

<?php echo 'Ending tag excluded';
<p>But html is still visible</p>

The second one would give error. Exclude ?> if you no more html to write after the code.