# Database objects naming conventions

# 1 Goal

Establish database object naming standards

# 2. Definitions

`` `
DBMS - Database Management System
OLTP - On-line Transactional Processing
`` `
# 3. Objective

## 3.2 General Considerations

For the name of any object, the following rules must be followed:

- Must start with a letter
- Must contain only alphanumerics (A-Z, 0-9) and "underscore" (_), considering 
size limitations for names in the environments used.

## 3.3 Data Environment Structural Objects

## 3.3.1 System

`` `
<significative_text>, up to 10 characters
`` `
## 3.3.2 Database

`` `
<significative_text>, considering the size limitation in the environments used
`` `
## 3.3.3 Database Link

`` `
<database>_<significative_text> where <significative_text> is optional
`` `
Ex.: PEPRNCE, DEPWBA, BCP5_OG00_CONSULTA

## 3.3.4 Tablespace

The Tablespace name must consist of:

**Owner_<object type>_NN,** where:

- <object type> (optional) can be: DATA, INDEX or LOBS

- NN = Sequential Number (optional)

Ex .: OG00_

## 3.4 Data Model Objects

## 3.4.1 Comments

Column and table comments must be filled

Ex.:
`` `sql
COMMENT ON TABLE OWN.CLIENT
IS 'Customer who can make an in-app purchase.'

COMMENT ON COLUMN OWN.CLIENT.CLIE_CD_CLIENT
IS 'Customer identifier code.'
`` `

## 3.4.2 Owner

**<significative_text>,** up to 7 characters

## 3.4.3 Table

Free and meaningful text, noting that the name must be in singular
and, if composed of two or more words, these might be
separated by "underscore":

**_<_** **term1>_<term2>_..._<termN** **_>_**

Must be a name preferably in masculine and in capital letters

The term must be at least 2 letters. Terms with 2 letters only
should be used if the term already has a known acronym with
this size

Ex .: RG / UF

Prepositions and articles should not be used in the composition of the name.

Avoid technical names and proper names unless it is well-known in the company

Ex: FGTS_BALANCE, VACATION_SHEET

## 3.4.4 View

**VW_<term1>_<term2>_..._<termN>**

The view columns must have the same name as the source table column.

## 3.4.4.1 Materialized View

**MV_<term1>_<term2>_..._<termN>**

The view columns must have the same name as the source table column.

## 3.4.5 Table Mnemonic

Used as a prefix to the column name of a table,
as mentioned in item 3.4.6, Column must contain up to four
alphanumeric characters (A-Z,0-9)

If the table name consists of a single word, use the first four characters

Ex .: EMPLOYEE EMPL

If the table name is consisted of two words, use first two characters
of both words

Ex: DM_EMPLOYEE DMEM

If the table name consists of three words, use first two characters
of the first word, the first character of the
second and the first of the third word

Ex: CT_CONTROL_REPORT CTCR

When the table name consists of four or more
words, use the first two characters of the first word,
and for the remaining two characters, use the first
characters of the most significant words.

Ex: MM_BASE_QUERY_ATTRIBUTE_DIM MMBA

If in the same database the above rule
generate equal abbreviations, duplicates must be resolved
choosing another way to generate the abbreviations

## 3.4.5.1 View Mnemonic

For view and materialized view columns, which originate from
expression, it will be necessary to create a mnemonic for the
view (materialized view). Consider the same rule for
table mnemonic, neglecting the VW (MV) prefix. View item
5.4.5 Table Mnemonic.

Ex. VW_POINT_OPER POOP

EG: MV_POINT_OPER POOP

## 3.4.6 Column

**<mnemonic table>_<class code>_<significative text>**

For “table mnemonic” see item 3.4.5 Table mnemonic.

For views columns, as well from materialized views,
originated from an expression consider “mnemonic view” in the
place of "mnemonic table". See item 3.4.5.1 View Mnemonic.

When the column is part of a foreign key, its
name must be the same as the primary key column name in the
parent table, including the parent table mnemonic:

Ex .: EMPL_NR_REGISTRATION (employee registration number)

The "class codes" described below indicate the purpose
column usage

| Class Code | Description  |
| ---------- | -----------  |
| CD         | Code         |
| IN         | Indicator    |
| NR         | Number       |
| AB         | Abbreviation |?
| TX         | Text         |
| DS         | Description  |
| DT         | Date         |
| MS         | Measure      |?
| PR         | Percentage   |
| MM         | Multimedia   |
| VL         | Value        |
| NM         | Name         |
| QT         | Quantity     |
| SQ         | Sequential   |

**CD-** Code itself representing a
key, identifier, type, rating, category, level and
anything that requires decoding (CGC, point, CPF,
product, etc.)

Ex.:
- Code/identifier/title
- Code/identifier/federation unit
- Code/type/contract
- Code/classification/service item
- Code/category/vehicle
- Code/wage level/employee
- Code/educational level/employee

**IN-** Restricted domain indication, in the sense of pointing
(Y, N), marker (*), sign (+, -), element of
distinction (alphanumeric set)

Ex.:
- Indicator/signal-differential-pressure/cannon
- Indicator/Status/supplier
- Indicator/additive/contract

**NR-** Free cardinal numbering representing a
string or constant

Ex.:
- Number/identity/employee
- Number/year/employee

**AB-** Abbreviation or simple character set (with
meaning) that identifies real world objects

Ex.:
- Acronym/State/boarding place
- Acronym/identifier/agency

**TX-** Free Comment, Free Observation, Explanation,
exemplification, meaning, etc.

Ex.:
- Text/observation/equipment
- Text/explanation/process
- Text/exemplification/sample
- Text/meaning-evaluation/contract

**DS-** Description of something or being, without predefined
format and no strict padding rules

Ex.:
- Description/type
- Description/status

**DT-** Any date (complete or not) that expresses the
effective date of an event

Ex.:
- Date/admission/employee
- Date/year-month-readjustment/contract

**MS-** Number expressing a quantity subject to the
measurement such as weight, capacity, area, depth,
distance, perimeter, flow, pressure, density,
speed, length, etc.

Ex.:
- Measure/weight/equipment
- Measure/capacity/tank
- Measure/area/field
- Measure/depth/well
- Measure/distance/place-of-delivery
- Measure/perimeter/location
- Measure/flow/equipment
- Measurement/pressure/equipment
- Measure/density/product
- Measure/speed/ship

**PR-** Number expressing a percentage or rate.

Ex.:
- Percentage/profit-sharing/employee
- Percentage/ipi/item-material

**MM-** Multimedia elements such as graphics, images,
sounds, movies or animations

Ex.:
- Multimedia/photo/employee
- Multimedia/graphic/template
- Multimedia/movie/news
- Multimedia/sound/message

**VL-** Only monetary amount expressing 
cost, price, payment, receipt, etc.

Ex.:
- Value/unit/service-item
- Value/fob/product
- Value/total/billing
- Value/refund/contract

**NM-** Full or abbreviated name of individual /
legal or "object"

Ex.:
- Name/full-name/employee
- Name/corporate-name/company
- Name/state-territory/federation-unit

**QT-** Number expressing a quantity obtained
by counting the treated object except monetary 
values and measurements, or simply a quantitative
accumulation

Ex.:
- Quantity/total/shipment
- Quantity/stock/product

**SQ-** Expresses sequential field or auto increment

Regarding "significant_text", do not use it in a redundant
way with "class code" such as:

Ex.1: AVFI_CD_CODE (Table: PHYSICAL_EVALUATION)

Ex.2: ATED_QN_QUANTITY (Table: EDUCTIVE_ACTIVITY)

Ex.3: FUNC_NM_FATHER_NAME (Table: EMPLOYEE)

Ex.4: FUNC_DT_BORN_DATE (Table: EMPLOYEE)

Use:

Ex.1: AVFI_CD_EVALUATION (Table: PHYSICAL EVALUATION)

Ex.2: ATED_QN_CONTRACTED (Table: EDUCTIVE_ACTIVITY)

Ex.3: FUNC_NM_FATHER (Table: EMPLOYEE)

Ex.4: FUNC_DT_BORN (Table: EMPLOYEE)

## 3.4.7 Constraints

## 3.4.7.1 Primary Key

Column or column combination that identifies a single row
in a table and with which the other columns maintain a
dependency relationship

**PK_<mnemonic table>**

For “mnemonic table” see item 3.4.5 Mnemonic of Table

Columns belonging to the primary key cannot have null value

Ex. PK_EMPL

## 3.4.7.2 Foreign Key

Column or column combination defined as foreign
key which relates to a primary key in
another or in the same table

**FK_<mnemonic parent table>_<mnemonic child
table>_<optional meaningful text>**

For “mnemonic table” see item 3.4.5 Mnemonic Table

The “optional meaningful text” should be used as
when there is more than one relationship between
the two tables.

Columns belonging to the primary key cannot have
null value

Ex .: FK_USR_RESP_PARENT

## 3.4.7.3 Unique

Column or column combination that identifies a single row
in a table. Unlike the primary key, these columns
don't have a dependency relationship

The columns belonging to the unique constraint can have
null value

**UN_<table mnemonic>_<meaningful text>**

For “mnemonic table” see item 3.4.5 Mnemonic Table

It is preferable that the “meaningful text” contains reference to
columns involved

Ex: UN_EMPL_EMPL_NR_CGC

## 3.4.7.4 Check

Define valores válidos para uma ou mais colunas de uma tabela.

**CK_<mnemônico tabela>_<texto significativo>**

O nome significativo deve esclarecer o tipo de informação que a
check constraint está validando

Sobre “mnemônico tabela” ver o item 3.4.5 Mnemônico de
Tabela

Ex.: CK_EMPR_NR_HORAS

## 3.4.8 Default

Define um valor padrão a ser associado a determinadas colunas
quando não são estabelecidos valores para elas

Uma alternativa para definir um default é a utilização da cláusula
DEFAULT no momento em que se cria a tabela

**DF_<texto significativo>**

É preferível que o “texto_significativo” contenha referência às
colunas envolvidas

Ex: DF_EMPR_DT_INCL

## 3.4.9 Índice

Estrutura associada a uma ou mais colunas com o objetivo de
otimizar consultas ou impor integridade. Ao ser definida a
constraint primary key ou unique, o SGBD cria automaticamente
um índice único e utiliza o mesmo nome da constraint para
nomeá-lo

Índice _constraint_ (chave primária, _unique_ e _foreing key_ )
O índice utiliza o mesmo nome da _constraint_.

Índice secundário
**IN_<mnemônico tabela>_<texto significativo>**

```
Sobre “mnemônico tabela” ver o item 3.4.
Mnemônico de Tabela
```

```
É preferível que o “texto significativo” contenha
referência às colunas envolvidas
```
Ex.: IN_EMPR_CPF

## 3.4.10 User Data Type

Tipos de dados definidos pelo usuário

**UDT_<texto significativo>**

Ex.: UDT_EMPR_DATA

## 3.4.11 Sequence (SGBD Oracle)

Objeto do banco de dados que gera números seqüenciais para
utilização em tabelas

**SQ_<nome da coluna>**

Ex.: SQ_STPR_CD_PROJ

## 3.4.12 Role

É um conjunto de permissões de acesso a objetos de um
determinado Banco de Dados. Deve ser nomeado em letras
maiúsculas

**R<texto significativo>**

## 3.4.13 Unidades de Programa

## 3.4.13.1 Gatilho (Trigger)

É um procedimento disparado automaticamente após cada
operação de _insert, update ou delete_ , específico para cada tipo
de operação

**TR<tipo>_<evento>_<mnemônico_tabela>_<função>_<sistema>,**
onde:

- Tipo pode ser:

```
G – Trigger de Integridade Referencial (tabela)
M – Trigger Mutante
V – Trigger de View
```
- Evento pode ser:

```
AS - After Statement
BS - Before Statement
AR - After Row
BR - Before Row
```

- Sobre “mnemônico tabela” ver o item 3.4.5 Mnemônico de Tabela

- Função pode ser:

```
INS - para trigger de inclusão
DEL - para trigger de exclusão
UPD - para trigger de update
IUD - combinação que indica os eventos de "Insert", "Update" e "Delete"
IU - combinação que indica os eventos de "Insert" e "Update"
ID - combinação que indica os eventos de "Insert" e "Delete"
DU - combinação que indica os eventos de "Delete" e "Update"
```

- Sistema é opcional

Ex.: TRG_AR_PESS_IU, TRG_AR_TERC_IU_OG

## 3.4.13.2 Função ( Function )

É uma função armazenada dentro do próprio banco de dados,
que é chamada por meio de _select_ e retorna um valor

**UFC_<sistema>_<texto significativo>**

Ex.: UFC_TC00_NIVEL_ACESSO

## 3.4.13.3 Procedimento Armazenado (Stored Procedure)

É uma rotina armazenada dentro do próprio banco de dados.
Alguns procedimentos podem ser retirados da aplicação e
transformados em stored procedures. O grau de complexidade
de uma stored procedure e a linguagem utilizada em sua
codificação dependem do SGBD utilizado

**USP_<sistema>_<texto significativo>_<operação>**

A operação executada pode ser:

```
UPD - procedimentos de UPDATE
INS - procedimentos de INSERT
DEL - procedimentos de DELETE
IUD - procedimentos INSERT, UPDATE e DELETE.
IU - combinação que indica os eventos de "Insert" e "Update"
ID - combinação que indica os eventos de "Insert" e "Delete"
DU - combinação que indica os eventos de "Delete" e "Update"
```

OBS: Quando for uma Stored Procedure somente de consulta,
colocar como padrão

**USP_<sistema>_<texto significativo>**

Não utilizar nada na parte de operação

Ex.: USP_TC00_LIBERA_RECURSO_IU

## 3.4.13.4 Package (SGBD Oracle)

São definições de dados e stored procedures armazenadas
dentro do próprio banco de dados ORACLE

**PCK_<sistema>_<texto significativo>**

Ex.: PCK_TC00_CONTROLE_ACESSO

## 3.4.13.5 Synonyms

O nome do sinônimo é o nome do objeto ao qual ele faz
referência
