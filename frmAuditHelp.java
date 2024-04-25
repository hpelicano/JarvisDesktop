/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.fiserv.jarvis.forms;

/**
 *
 * @author F1W1JF7
 */
public class frmAuditHelp extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmAuditHelp
     */
    public frmAuditHelp() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 255));
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("AUDIT HELP");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 2, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("NETADRD Syntax is:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 30));

        jTextPane1.setText("  [RUN] NETADRD [/ OUT list-file /] <audit-file-name>\n    [, [NO] REAL-TIME ]\n    [, <select-option> [, <select-option> ...] ]\n    [, <output-option> [, <output-option> ...] ]\n    [, <display-option> [, <display-option> ...] ]\n    [, FILTER <filter-file-name> ]\n    [, PREFIX <3 character audit file prefix> ]\n    [, QWRITE <queue-file-name>  ]  where <queue-file-name>\n         is an output file to be created by NETADRD in audit\n         file format and will have the selected messages\n         written to it.\n\n    where:\n\n      <select-option> is one of (abbreviation shown):\n\n        AUDMESSAGES(AUDM) ON/OFF/ONLY\n        COUNT <number>\n        DEST(D) <route-code>\n        DEST(D) \"<sym-name>\"\n        FIRST   <number>\n        SOURCE(S) <route-code>\n        SOURCE(S) \"<sym-name>\"\n        [SOURCE(S) <route-code> AND DEST(D) <route-code>]\n        [SOURCE(S) \"<sym-name>\" AND DEST(D) \"<sym-name>\"]\n        TIME <start-time>[/ <stop-time> ]\n        DATE YYYY/MM/DD\n        TYPE <audit-record-type>\n        MAXFILES <number>\n\n      <output-option> is one of (abbreviation shown):\n\n        [NO] CONTINUE  ( continue processing indexed files )\n        [NO] HEADER\n        [NO] MSGHEADER [DETAIL]\n        [NO] REPORT\n        [NO] TEXT\n        [NO] TRUNCATE\n        [NO] PAYLOAD(PAY)\n        [NO] USER               (outputs userdata if any)\n\n      <display-option> is one of (abbreviation shown):\n\n        [NO] ASCII(A)\n        [NO] BYTE\n        [NO] CONTROL\n        [NO] DECIMAL(DEC)\n        [NO] EBCDIC(E)\n        [NO] HEX(H)\n             HEXASCII(HEXA)     (hex/ASCII formatted output)\n        [NO] OCTAL(O)\n        [NO] TRANSPARENT\n        RECOUT <number>");
        jScrollPane1.setViewportView(jTextPane1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 380, 450));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 400, 510));

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextPane2.setText("Decomposes BASE24 messages held in a file and displays them on the\nscreen or writes them to the current 'out' destination.  If an 'out'\nfile is specified, the program defaults to creating an edit file.\n\nMessages can be displayed as they are added to the file (see -REAltime\nand -FORever below).\n\nAs at September 2005, the code should handle ISO8583 interchange,\nISO HISO, ISO BIC, Euro/Mastercard, VISA ISO8583, SPDH, NCR NDC+,\nDiebold DDC, Wincor DDC, Triton, LINK's ISO8583, BIM ISO8583,\nSPDH, and some AmEx messages.\n\nThe program provides for ASCII and EBCDIC text.\n\nThe source file may be an XPNet audit file, an XPNet queue file, an\nentry-sequenced file, a SAF... containing whole BASE24 messages or just\nthe message text (mtp...).\n\nBreak handling: When break is pressed, the program enters 'page' mode.\n(If already in page mode, the program terminates)  In page mode, after\neach record is displayed, you have the choices of 'next record', 'exit\nprogram', or 'run'.\n\nNote: Relays audit records through a short sorted queue to try to\n      get records into sequence instead of B24 audit file order.\n      (Except when -REC is specified - records are then\n       displayed in strict record number order)\nNote: Tested mainly on audit files.\n\nThe command is:\n\nexplode [/[IN ...,][OUT ...,]../] <messagefile> [<switch> <value>...]...\n\n<messagefile> contains the messages to be decomposed.\nIf an IN file is specified, options will be got from the IN file then\noverridden with command line options, if any (see Ex). The IN file can\ncontain comments (==, --, or ! at start of line).\n\nSwitch      Description                                     Default\n----------- ---------------------------------------------   ------------------\n-ACK        Displays messages of length zero.             | Skipped\n-ALL ...    Selects messages with the specified XPNet     | All\n            name(s) as either source or destination.      |\n            The names may contain wildcards (see end of   |\n            this list).  Up to 16 names may be specified. |\n-AND        See also -src and -dest.  Selects messages    | Either\n            whose source matches one of those specified   |\n            by -src AND whose destination matches one of  |\n            those specified by -des.                      |\n-ASCii      Displays messages as ASCII dumps, optionally  | Formatted\n            with hex and EBCDIC (see -HEX and -EBC)       |\n-AS7        Same as -ASC, but ignores the most            | Formatted\n            significant bit of each byte (e.g. xC1 = 'A') |\n-BIM        Forces use of Netherlands BIM ISO8583 specs   | AI\n            in expanding ISO8583 messages.                |\n-COUnt ..   Displays the specified number of messages     | All\n-DEC ..     Number of decimal positions in (some) amounts.| 2\n-DEL ...    Appends a delimiter character to the end of   | No delimiter\n            each displayed ISO8583 field.  If -del is     |\n            specified with no character, ']' is used.     |\n-DESt ..    Selects messages with the specified XPNet     | All dests\n            destination names only.  The names may        |\n            contain wildcards (see end of this list).     |\n            Up to 16 names may be specified. See Ex.      |\n-DETail     Expanded display of some fields, such as EMV  | Raw fields\n            data.                                         |\n-DNB        Decomposes track 3 in the BG token and in NDC+|\n            messages according to Norwegian standards.    |\n-EBCdic     Displays messages as EBCDIC dumps, optionally | Formatted\n            with hex and ASCII (see -HEX, -ASC, -AS7)     |\n-EXTract .. (Audit input only)  Appends the selected      |\n            audit records to the specified file, creating |\n            the file if necessary.  (see also -NOD)       |\n-FIElds     Displays (only) a table of the ISO standard   |\n            bit numbers and field descriptions.           |\n-FIRst ..   Displays the specified record first - numbers | Record 0\n            are base 0, to match B24 netadrd numbering.   |\n-FORever    This is the same as -REAl, but will wait 24   |\n            hours for a new record before terminating.    |\n-FROm ...   Specifies by date and/or time or time offset  | Record 0\n            which record to start from.  Date is dd/mm/yy |\n            or ddmmyy, time is hh:mm or hh:mm:ss.  If date|\n            is omitted, today is assumed.  If time is     |\n            omitted, 00:00:00 is assumed.  If a time      |\n            offset is specified, it must be -n, -nn, or   |\n            -nnn (minutes) or -hh:mm or -hh:mm:ss.        |\n            Offsets are backwards from 'now' and must     |\n            always include the minus sign.                |\n-HELp       Displays this help text.                      |\n-HEX        Displays messages as hex dumps, optionally    | Formatted\n            with ASCII and EBCDIC (see -ASC, -AS7, -EBC)  |\n-HISo ABN   Displays HISO messages in CSM'd format - the  | Formatted\n            only possible option value (July 05) is ABN.  |\n-ISO 8      Displays ISO as standard, except terminal ID, |\n            which is assumed to be 8 bytes, not 16.       |\n-ISO BIM    Uses Netherlands BIM ISO8583 specs for ISO    |\n            messages.                                     |\n-LOOp ...   Selects messages in either direction along    | All\n            the specified path of stations and processes. |\n            Names may contain wildcards (see end of this  |\n            list).  See also -PATh.                       |\n-MSGs ...   (replaced by -REC)                            |\n-NODisplay  Does not display records.  (see also -EXT)    | Displayed\n-NMM OFF    See -NONmm                                    | Displayed\n-NONmm      Switches off display of network management    | Displayed\n            messages (08xx).                              |\n-PAGe       Displays one message at a time then waits for | Continuous\n            user keyboard input.                          |\n-PATh ...   Selects messages traversing any step along    | All\n            the specified path of stations and processes  |\n            in a forward direction.  Names may contain    |\n            wildcards (see end of this list).  See also   |\n            -LOOp.                                        |\n-PSTm       Display PSTM body in a partially-expanded     | Raw dump\n            format.                                       |\n-RAW        Dumps the message data in 70-character lines, | Formatted\n            replacing unprintable characters with '.'.    |\n            (Incompatible with all other formatting       |\n            options)                                      |\n-REAltime   Displays the current contents of the file     | Stop at EOF\n            then displays further records as they are     |\n            added to the file.                            |\n            ***NB Program terminates if it waits an hour  |\n               with no record added to the file.  See     |\n               also -FORever.                             |\n-RECords..  Selects only the specified records.  Up to    | All\n            16 numbers or ranges may be specified -       |\n            e.g. -rec 50 52/57 75 128/175                 |\n            NB The first record is number 0.              |\n-SOUrce ..  Selects messages with the specified XPNet     | All sources\n            source names only.  The names may contain     |\n            wildcards (see end of this list).             |\n            Up to 16 names may be specified. See Ex.      |\n-SRC ..     Same as -SOUrce.                              |\n-STArt...   Same as -FROm.                                | Record 0\n-STM        Display STM body in a partially-expanded      | Raw dump\n            format.                                       |\n-SUBfields  (replaced by -DETail)                         | Raw fields\n-TKN        Formatted output of some custom tokens.       | Dump\n-TO ...     Specifies end date/time - see -FROm for       | End of file\n            format.                                       |\n-TOKens     same as -TKN                                  |\n-UNIque     Eliminates the display of duplicate messages  |\n            (audit files only).                           |\n\nWildcard names may contain any number of asterisks (*) and\nquestion-marks (?), but 2 asterisks together are rejected.\nAn asterisk matches any number of characters, including\nnone.\nA question-mark matches any one non-blank character.\n\nEx.\n   (Note: Only the first 3 characters of a switch are required e.g.\n          -cou for -count)\n   explode aud05161 -real -start -2\n   explode aud05161 -real -from -2\n      - realtime, from 2 minutes ago\n   explode aud05161 -hex -asc -rec 10 12 14\n      - dump records 10, 12, and 14 in hex and ASCII.\n   explode aud05161 -page\n      - one message at a time\n   explode aud05161 -sou s1a^visa* -nonmm -det\n      - from any VISA station, no 08xx, detailed expansion\n   explode aud05161 -path ATM001 p8a^n502 p8a^auth* p8a^visa s8a^visa\n      - any message taking a forward step along the specified path\n   explode aud05161 -loop ATM001 p8a^n502 p8a^auth* p8a^visa s8a^visa\n      - any message taking a step along the specified path in either\n        direction\n   explode aud05161 -src ????visa*\n      - from any VISA process or station\n   explode aud05161 -all s1a^visa*\n      - to or from any VISA station\n   explode /out ed05141/ aud05141 -from 10:50\n      - output to an Edit file, starting from 10:50 today\n   explode /out ex05141/ aud05141 -from 250699 10:50\n   explode /out aude141/ aud05141 -from 25/06/99 10:50\n      - output to an Edit file, starting from 10:50 25th June 1999\n   explode /out $s.#aud/ aud05161 -fir 531 -count 10\n      - output to the spooler, starting from the 531st msg, 10 msgs\n   explode aud05161 -del +\n      - append '+' to each line (helps when fields end in spaces)\n   explode aud05161 -src p1a^visa* p1a^euro*\n      - messages from VISA or EURO processes\n   explode aud05161 -des 2080* 2081* term2* -real\n      - messages to stations with names starting 2080 etc, realtime\n   explode aud05161 -src p1a^bic* -and -dest s1a^bic*\n      - messages from BIC processes to BIC stations only\n   explode aud05161 -des ??a^*m\n      - messages to node A destinations with names ending in M\n   explode /in atm1426/\n      - all options are got from the IN file\n   explode /in visaloop/ aud05161\n      - all options except the audit file name are got from the IN file\n   explode p1tauda -from 00:00 -ext p1ttoday\n      - writes the selected audit records to audit file 'p1ttoday'");
        jScrollPane2.setViewportView(jTextPane2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 380, 450));

        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("EXPLODE Syntax is:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 30));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 400, 510));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    // End of variables declaration//GEN-END:variables
}
