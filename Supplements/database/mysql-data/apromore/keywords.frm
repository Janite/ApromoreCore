TYPE=VIEW
query=select `apromore`.`process`.`id` AS `processId`,`apromore`.`process`.`id` AS `value` from `apromore`.`process` union select `apromore`.`process`.`id` AS `processId`,`apromore`.`process`.`name` AS `word` from `apromore`.`process` union select `apromore`.`process`.`id` AS `processId`,`apromore`.`process`.`domain` AS `domain` from `apromore`.`process` union select `apromore`.`process`.`id` AS `processId`,`apromore`.`native_type`.`nat_type` AS `original_type` from (`apromore`.`process` join `apromore`.`native_type` on((`apromore`.`process`.`nativeTypeId` = `apromore`.`native_type`.`id`))) union select `apromore`.`process`.`id` AS `processId`,`apromore`.`user`.`first_name` AS `firstname` from (`apromore`.`process` join `apromore`.`user` on((`apromore`.`process`.`owner` = `apromore`.`user`.`username`))) union select `apromore`.`process`.`id` AS `processId`,`apromore`.`user`.`last_name` AS `lastname` from (`apromore`.`process` join `apromore`.`user` on((`apromore`.`process`.`owner` = `apromore`.`user`.`username`))) union select `apromore`.`process_branch`.`processId` AS `processId`,`apromore`.`process_branch`.`branch_name` AS `branch_name` from `apromore`.`process_branch`
md5=2e01cae5087696a8157ca7388db4f098
updatable=0
algorithm=0
definer_user=root
definer_host=localhost
suid=1
with_check_option=0
timestamp=2019-11-11 23:24:12
create-version=1
source=select `process`.`id` AS `processId`,`process`.`id` AS `value` from `process` union select `process`.`id` AS `processId`,`process`.`name` AS `word` from `process` union select `process`.`id` AS `processId`,`process`.`domain` AS `domain` from `process` union select `process`.`id` AS `processId`,`native_type`.`nat_type` AS `original_type` from (`process` join `native_type` on((`process`.`nativeTypeId` = `native_type`.`id`))) union select `process`.`id` AS `processId`,`user`.`first_name` AS `firstname` from (`process` join `user` on((`process`.`owner` = `user`.`username`))) union select `process`.`id` AS `processId`,`user`.`last_name` AS `lastname` from (`process` join `user` on((`process`.`owner` = `user`.`username`))) union select `process_branch`.`processId` AS `processId`,`process_branch`.`branch_name` AS `branch_name` from `process_branch`
client_cs_name=utf8
connection_cl_name=utf8_general_ci
view_body_utf8=select `apromore`.`process`.`id` AS `processId`,`apromore`.`process`.`id` AS `value` from `apromore`.`process` union select `apromore`.`process`.`id` AS `processId`,`apromore`.`process`.`name` AS `word` from `apromore`.`process` union select `apromore`.`process`.`id` AS `processId`,`apromore`.`process`.`domain` AS `domain` from `apromore`.`process` union select `apromore`.`process`.`id` AS `processId`,`apromore`.`native_type`.`nat_type` AS `original_type` from (`apromore`.`process` join `apromore`.`native_type` on((`apromore`.`process`.`nativeTypeId` = `apromore`.`native_type`.`id`))) union select `apromore`.`process`.`id` AS `processId`,`apromore`.`user`.`first_name` AS `firstname` from (`apromore`.`process` join `apromore`.`user` on((`apromore`.`process`.`owner` = `apromore`.`user`.`username`))) union select `apromore`.`process`.`id` AS `processId`,`apromore`.`user`.`last_name` AS `lastname` from (`apromore`.`process` join `apromore`.`user` on((`apromore`.`process`.`owner` = `apromore`.`user`.`username`))) union select `apromore`.`process_branch`.`processId` AS `processId`,`apromore`.`process_branch`.`branch_name` AS `branch_name` from `apromore`.`process_branch`
