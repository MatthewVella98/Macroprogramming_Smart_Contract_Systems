grammar ts;

program:
Program WHITE_SPACE* OPEN_CBRACE WHITE_SPACE*
(logic_item)* WHITE_SPACE*
(data_item)* WHITE_SPACE*
CLOSE_CBRACE WHITE_SPACE*
;

data_item:
  data_property
| data_participant
| data_participant_identities
;

data_property:
Data WHITE_SPACE* Property WHITE_SPACE* OPEN_BLOCK WHITE_SPACE*
(data_element WHITE_SPACE*)+ WHITE_SPACE*
CLOSE_BLOCK WHITE_SPACE*
;

data_participant:
Data WHITE_SPACE* Participant WHITE_SPACE* OPEN_BLOCK WHITE_SPACE*
(data_element WHITE_SPACE*)+ WHITE_SPACE*
CLOSE_BLOCK WHITE_SPACE*
;

data_participant_identities:
Data WHITE_SPACE* Participant_x509Identities WHITE_SPACE* OPEN_BLOCK WHITE_SPACE*
(data_element WHITE_SPACE*)+ WHITE_SPACE*
CLOSE_BLOCK WHITE_SPACE*
;

data_element:
data_annotation_list PUBLIC WHITE_SPACE* data_declaration WHITE_SPACE* SEMICOLON
;

data_declaration:
READONLY WHITE_SPACE* TYPE_KEYWORD WHITE_SPACE* EQUAL WHITE_SPACE* domain_type
| identifier WHITE_SPACE* COLON WHITE_SPACE* type
;

domain_type:
SINGLE_QUOTED_LITERAL
;

data_annotation_list:
(data_annotation WHITE_SPACE*)+
;

data_annotation:
REQUIRED_ANNOTATION
| VALIDATE_ANNOTATION
| READONLY_ANNOTATION
| X_ONLY_ON_CHAIN_ANNOTATION
| X_ALL_ANNOTATION
;

logic_item:
comment? WHITE_SPACE*
x_logic_item WHITE_SPACE*
;

x_logic_item:
x_on_chain_separate
| x_on_main_system_separate
| x_both
;

x_on_chain_separate:
X_ON_CHAIN_ANNOTATION OPEN_BRACKET CLOSE_BRACKET WHITE_SPACE* OPEN_BLOCK WHITE_SPACE*
FUNCTION WHITE_SPACE* controller_and_function WHITE_SPACE*
OPEN_BRACKET WHITE_SPACE* list_of_params WHITE_SPACE* CLOSE_BRACKET WHITE_SPACE*
    OPEN_CBRACE 
	block_of_code? 
    CLOSE_CBRACE WHITE_SPACE*
CLOSE_BLOCK WHITE_SPACE*
;

x_on_main_system_separate:
X_ON_MAIN_SYSTEM_ANNOTATION OPEN_BRACKET CLOSE_BRACKET WHITE_SPACE* OPEN_BLOCK WHITE_SPACE*
FUNCTION WHITE_SPACE* function_name WHITE_SPACE*
OPEN_BRACKET WHITE_SPACE* list_of_params WHITE_SPACE* CLOSE_BRACKET WHITE_SPACE*
    OPEN_CBRACE
	block_of_code? 
    CLOSE_CBRACE WHITE_SPACE*
CLOSE_BLOCK WHITE_SPACE*
;

x_both:
X_ON_MAIN_SYSTEM_ANNOTATION OPEN_BRACKET CLOSE_BRACKET WHITE_SPACE* OPEN_BLOCK WHITE_SPACE*
FUNCTION WHITE_SPACE* controller_and_function WHITE_SPACE*
OPEN_BRACKET WHITE_SPACE* list_of_params WHITE_SPACE* CLOSE_BRACKET WHITE_SPACE*

X_ON_CHAIN_ANNOTATION OPEN_BRACKET CLOSE_BRACKET WHITE_SPACE*
    OPEN_BLOCK 
	block_of_code_inner? 
	CLOSE_BLOCK

block_of_code_outer?
CLOSE_BLOCK WHITE_SPACE*    
;

/*function_specifiers:
FUNCTION 
;*/

block_of_code :
 (.)+?
;

block_of_code_inner :
 (.)+?
;

block_of_code_outer :
 (.)+?
;

comment :
COMMENT_START (.)*? COMMENT_END
;

function_name:
IDENTIFIER
;

controller_and_function :
IDENTIFIER
;

list_of_params:
param_declaration? WHITE_SPACE* (WHITE_SPACE* COMMA WHITE_SPACE* param_declaration WHITE_SPACE*)*
;

param_declaration:
identifier WHITE_SPACE* COLON WHITE_SPACE* type
;

identifier:
IDENTIFIER
;

type : 
TYPE |
generic
;

generic:
IDENTIFIER LESS_EQUAL IDENTIFIER GREATER_EQUAL |
IDENTIFIER LESS_EQUAL generic GREATER_EQUAL 
;

SINGLE_QUOTED_LITERAL:
'\'' (~('\''))* '\''
| '`' (~('`'))* '`'
;

TYPE :
STRING | NUMBER | BOOLEAN
;

Program: 'program';
Data: 'data';
Property: 'Property';
Participant: 'Participant';
Participant_x509Identities :'Participant_x509Identities';

FUNCTION : 'function';
STRING : 'string';
NUMBER : 'number';
BOOLEAN : 'boolean';

READONLY: 'readonly';
TYPE_KEYWORD: 'type';

PUBLIC : 'public';
ASYNC : 'async';

X_ON_CHAIN_ANNOTATION: '@XOnChain' ;
X_ON_MAIN_SYSTEM_ANNOTATION: '@XOnMainSystem' ;
X_ALL_ANNOTATION: '@XAll'; 
X_ONLY_ON_CHAIN_ANNOTATION: '@XOnlyOnChain';

READONLY_ANNOTATION: '@ReadOnly' OPEN_BRACKET CLOSE_BRACKET;
VALIDATE_ANNOTATION: '@Validate' OPEN_BRACKET WHITE_SPACE* YUP TYPE WHITE_SPACE* OPEN_BRACKET CLOSE_BRACKET CLOSE_BRACKET;
REQUIRED_ANNOTATION: '@Required' OPEN_BRACKET CLOSE_BRACKET;
YUP: 'yup.';

COMMENT_START: '/*';
COMMENT_END: '*/';

LESS_EQUAL : '<';
GREATER_EQUAL : '>';
OPEN_BLOCK: '{{';
CLOSE_BLOCK: '}}';
EQUAL: '=';
SEMICOLON : ';' ;
COLON : ':' ;
COMMA : ',' ;
OPEN_BRACKET : '(' ;
CLOSE_BRACKET : ')' ;
OPEN_CBRACE : '{' ;
CLOSE_CBRACE : '}' ;
//UNDERSCORE: '_';

IDENTIFIER
 : '[' ~']'* ']'
 | [a-zA-Z_] [a-zA-Z_0-9.\-]* 
 | [A-Z]+ '-' [0-9]+ 
 ;
 
WHITE_SPACE
 : [ \u000B\t\r\n] 
 ;
 
ERROR_CHAR : . ;

