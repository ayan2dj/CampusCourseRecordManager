# CCRM Usage

## Compile and Run
- PowerShell:
  - `javac -d out $(Get-ChildItem -Recurse src\main\java\*.java | ForEach-Object { $_.FullName })`
  - `java -cp out edu.ccrm.cli.Main`

## Sample Workflow
1) Import sample data from `test-data/` via Import/Export menu.
2) List students and courses.
3) Enroll a student in a course.
4) Record marks.
5) Print transcript and reports.
6) Export data to `exported/`.
7) Create a backup; note timestamped folder in `backups/` and shown size.

## Example Outputs
- Welcome message: `Welcome to CCRM`
- Reports: Top students by GPA, GPA distribution histogram

## Assertions
- Run with `-ea` to enable assertions.
