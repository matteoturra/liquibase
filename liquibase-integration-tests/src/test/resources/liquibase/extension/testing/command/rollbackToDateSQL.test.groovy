package liquibase.extension.testing.command

CommandTests.define {
    command = ["rollbackToDateSQL"]
    signature = """
Short Description: Generate the SQL to rollback changes made to the database based on the specific date
Long Description: Generate the SQL to rollback changes made to the database based on the specific date
Required Args:
  date (LocalDateTime) Date to rollback changes to
  url (String) The JDBC database connection URL
Optional Args:
  changeLogFile (String) The root changelog
    Default: null
  contexts (String) Changeset contexts to match
    Default: null
  labels (String) Changeset labels to match
    Default: null
  password (String) Password to use to connect to the database
    Default: null
  rollbackScript (String) Rollback script to execute
    Default: null
  username (String) Username to use to connect to the database
    Default: null
"""

    run {
        arguments = [
                date         : "2021-03-25T09:00:00",
                changeLogFile: "changelogs/hsqldb/complete/rollback.changelog.xml",
        ]

        setup {
            runChangelog "changelogs/hsqldb/complete/rollback.changelog.xml"
        }

        expectedResults = [
                statusMessage: "Successfully executed rollbackToDateSQL",
                statusCode   : 0
        ]
    }
}
