package cs.dsa;
/**
 * 
 * 
 * Given a list of database transactions, find all read-write conflicts among them. Assume that there is no strict two-phase locking (Strict 2PL) protocol to prevent read-write conflicts.

Each database transaction is given in the form of a tuple. The tuple ('T', 'A', 't', 'R') indicates that a transaction T accessed a database record A at a time t, and a read operation is performed on the record.

Assume that a data conflict happens when two transactions access the same record in the database within an interval of 5 units. At least one write operation is performed on the record.

 
For example,

Input:
 
(T1, A, 0, R)
(T2, A, 2, W)
(T3, B, 4, W)
(T4, C, 5, W)
(T5, B, 7, R)
(T6, C, 8, W)
(T7, A, 9, R)
 
Output:
 
Transaction T1 and T2 are involved in RW conflict
Transaction T3 and T5 are involved in WR conflict
Transaction T4 and T6 are involved in WW conflict
 * 
 * 
 * 
 * 
 * @author csardar
 *
 */

import java.util.Arrays;
import java.util.List;
 
// A class to store transaction details
class Transaction
{
    String name;        // Transaction name
    String record;        // Data object from the database
    int timestamp;      // Timestamp of the current transaction
    char operation;     // Operation type: Read/Write
 
    public Transaction(String name, String record, int timestamp, char operation)
    {
        this.name = name;
        this.record = record;
        this.timestamp = timestamp;
        this.operation = operation;
    }
}

public class ReadWriteConflicts {

	public static void findConflicts(List<Transaction> t)
    {
        // Sort the transactions by database records. For the same database record,
        // sorting should be done in increasing order of access time
        t.sort((x, y) -> {
            // compare database records first
            if (!x.record.equals(y.record)) {
                return x.record.compareTo(y.record);
            }
            // compare based on access time when database records are equal
            return x.timestamp - y.timestamp;
        });
 
        // Consider each transaction and find their conflicting past transactions
        for (int i = 0; i < t.size(); i++)
        {
            // Start from the previous transaction
            int j = i - 1;
 
            // Consider all past transactions that have accessed the same
            // database record within an interval of 5 units
 
            while (j >= 0 && t.get(i).record.equals(t.get(j).record)
                    && t.get(i).timestamp <= t.get(j).timestamp + 5)
            {
                // At-least one write operation 'W' is performed on the record
                if (t.get(i).operation == 'W' || t.get(j).operation == 'W')
                {
                    System.out.println("Transaction " + t.get(j).name + " & " + t.get(i).name
                            + " are involved in " + t.get(j).operation
                            + t.get(i).operation + " conflict");
                }
 
                // move to the next previous transaction
                j--;
            }
        }
    }
 
    public static void main(String[] args)
    {
        List<Transaction> t = Arrays.asList(
                new Transaction("T1", "A", 0, 'R'),
                new Transaction("T2", "A", 2, 'W'),
                new Transaction("T3", "B", 4, 'W'),
                new Transaction("T4", "C", 5, 'W'),
                new Transaction("T5", "B", 7, 'R'),
                new Transaction("T6", "C", 8, 'W'),
                new Transaction("T7", "A", 9, 'R'));
 
        findConflicts(t);
    }

}
