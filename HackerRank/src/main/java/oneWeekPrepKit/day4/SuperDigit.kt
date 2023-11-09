package src.main.java.oneWeekPrepKit.day4


/*
 * Complete the 'superDigit' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. STRING n
 *  2. INTEGER k
 */

fun superDigit(n: String, k: Int): Int {
    // Write your code here
//    val s = if (k > 0) n.repeat(k) else n
    val s: String = if (k == 0) n else n.repeat(k)
//    TODO: convert to larger data type string is too large for Int conversion
    var sum: Int = if (k == 0) n.toInt() else s.toInt()
    for (i in s.indices) {
        sum += s[i].toString().toInt()
    }
    if (sum.toString().length > 1) {
        superDigit(sum.toString(), 0)
    }

//    print("$sum // ")
    /*    while (sum.toString().length > 1) {
            val s = sum.toString()
            sum = 0
            for (i in s.indices) {
                sum += s[i].toString().toInt()
            }
        }*/

    return sum.toInt()
}

fun main(args: Array<String>) {
//    val n = "7404954009694227446246375747227852213692570890717884174001587537145838723390362624487926131161112710589127423098959327020544003395792482625191721603328307774998124389641069884634086849138515079220750462317357487762780480576640689175346956135668451835480490089962406773267569650663927778867764315211280625033388271518264961090111547480467065229843613873499846390257375933040086863430523668050046930387013897062106309406874425001127890574986610018093859693455518413268914361859000614904461902442822577552997680098389183082654625098817411306985010658756762152160904278169491634807464356130877526392725432086439934006728914411061861235300979536190100734360684054557448454640750198466877185875290011114667186730452681943043971812380628117527172389889545776779555664826488520325234792648448625225364535053605515386730925070072896004645416713682004600636574389040662827182696337187610904694029221880801372864040345567230941110986028568372710970460116491983700312243090679537497139499778923997433720159174153"
//    val k = 100000
    val n = "9875"
    val k = 4
    val result = superDigit(n, k)

    println(result)
}

/*
* iterative passes some test cases
* fails with test case 6 attached
* */

/* Test case number n * k
* 7404954009694227446246375747227852213692570890717884174001587537145838723390362624487926131161112710589127423098959327020544003395792482625191721603328307774998124389641069884634086849138515079220750462317357487762780480576640689175346956135668451835480490089962406773267569650663927778867764315211280625033388271518264961090111547480467065229843613873499846390257375933040086863430523668050046930387013897062106309406874425001127890574986610018093859693455518413268914361859000614904461902442822577552997680098389183082654625098817411306985010658756762152160904278169491634807464356130877526392725432086439934006728914411061861235300979536190100734360684054557448454640750198466877185875290011114667186730452681943043971812380628117527172389889545776779555664826488520325234792648448625225364535053605515386730925070072896004645416713682004600636574389040662827182696337187610904694029221880801372864040345567230941110986028568372710970460116491983700312243090679537497139499778923997433720159174153
* 100000
* Expected output == 3
* */