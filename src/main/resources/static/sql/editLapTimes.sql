ALTER TABLE tu_tabla
ADD COLUMN lap_time_id INT AUTO_INCREMENT PRIMARY KEY DEFAULT valor_inicial FIRST;

SET @row_number = 0;

UPDATE lap_times
SET lap_time_id = (@row_number := @row_number + 1);