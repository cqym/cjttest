CREATE TABLE `tree_nodes` (
  `TreeID` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  `PID` int(11) DEFAULT NULL,
  `Name` varchar(200) NOT NULL,
  `OrderID` int(11) DEFAULT NULL,
  `Obsolete` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `fk_tree_nodes_tree_id` (`TreeID`) USING BTREE,
  KEY `fk_tree_nodes_id` (`PID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sys_sequence_next`(
    IN p_SequenceID integer,
    IN p_Step integer,
    OUT p_SequenceValue integer
)
BEGIN
  /*  SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    START TRANSACTION;*/

    UPDATE _sys_sequence
    SET SequenceValue = SequenceValue + p_Step
    WHERE SequenceID = p_SequenceID;

	  SET p_SequenceValue = -1;
    SELECT SequenceValue INTO p_SequenceValue
    FROM _sys_sequence
    WHERE  SequenceID = p_SequenceID;


  /*  COMMIT;*/
END;;
DELIMITER ;



CREATE TABLE `_sys_sequence` (
  `SequenceID` int(11) NOT NULL COMMENT '序列ID',
  `SequenceName` varchar(50) NOT NULL COMMENT '序列名称',
  `SequenceValue` int(11) NOT NULL COMMENT '序列值',
  PRIMARY KEY (`SequenceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='序列号';
