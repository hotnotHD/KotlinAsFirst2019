package lesson5.task1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class Tests {
    @Test
    @Tag("Example")
    fun shoppingListCostTest() {
        val itemCosts = mapOf(
            "Хлеб" to 50.0,
            "Молоко" to 100.0
        )
        assertEquals(
            150.0,
            shoppingListCost(
                listOf("Хлеб", "Молоко"),
                itemCosts
            )
        )
        assertEquals(
            150.0,
            shoppingListCost(
                listOf("Хлеб", "Молоко", "Кефир"),
                itemCosts
            )
        )
        assertEquals(
            0.0,
            shoppingListCost(
                listOf("Хлеб", "Молоко", "Кефир"),
                mapOf()
            )
        )
    }

    @Test
    @Tag("Example")
    fun filterByCountryCode() {
        val phoneBook = mutableMapOf(
            "Quagmire" to "+1-800-555-0143",
            "Adam's Ribs" to "+82-000-555-2960",
            "Pharmakon Industries" to "+1-800-555-6321"
        )

        filterByCountryCode(phoneBook, "+1")
        assertEquals(2, phoneBook.size)

        filterByCountryCode(phoneBook, "+1")
        assertEquals(2, phoneBook.size)

        filterByCountryCode(phoneBook, "+999")
        assertEquals(0, phoneBook.size)
    }

    @Test
    @Tag("Example")
    fun removeFillerWords() {
        assertEquals(
            "Я люблю Котлин".split(" "),
            removeFillerWords(
                "Я как-то люблю Котлин".split(" "),
                "как-то"
            )
        )
        assertEquals(
            "Я люблю Котлин".split(" "),
            removeFillerWords(
                "Я как-то люблю таки Котлин".split(" "),
                "как-то",
                "таки"
            )
        )
        assertEquals(
            "Я люблю Котлин".split(" "),
            removeFillerWords(
                "Я люблю Котлин".split(" "),
                "как-то",
                "таки"
            )
        )
    }

    @Test
    @Tag("Example")
    fun buildWordSet() {
        assertEquals(
            buildWordSet("Я люблю Котлин".split(" ")),
            mutableSetOf("Я", "люблю", "Котлин")
        )
        assertEquals(
            buildWordSet("Я люблю люблю Котлин".split(" ")),
            mutableSetOf("Котлин", "люблю", "Я")
        )
        assertEquals(
            buildWordSet(listOf()),
            mutableSetOf<String>()
        )
    }

    @Test
    @Tag("Easy")
    fun buildGrades() {
        assertEquals(
            mapOf<Int, List<String>>(),
            buildGrades(mapOf())
        )
        assertEquals(
            mapOf(5 to listOf("Михаил", "Семён"), 3 to listOf("Марат")),
            buildGrades(mapOf("Марат" to 3, "Семён" to 5, "Михаил" to 5))
                .mapValues { (_, v) -> v.sorted() }
        )
        assertEquals(
            mapOf(3 to listOf("Марат", "Михаил", "Семён")),
            buildGrades(mapOf("Марат" to 3, "Семён" to 3, "Михаил" to 3))
                .mapValues { (_, v) -> v.sorted() }
        )
    }

    @Test
    @Tag("Easy")
    fun containsIn() {
        assertTrue(containsIn(mapOf("a" to "z"), mapOf("a" to "z", "b" to "sweet")))
        assertFalse(containsIn(mapOf("a" to "z"), mapOf("a" to "zee", "b" to "sweet")))
    }

    @Test
    @Tag("Easy")
    fun subtractOf() {
        val from = mutableMapOf("a" to "z", "b" to "c")

        subtractOf(from, mapOf())
        assertEquals(from, mapOf("a" to "z", "b" to "c"))

        subtractOf(from, mapOf("b" to "z"))
        assertEquals(from, mapOf("a" to "z", "b" to "c"))

        subtractOf(from, mapOf("a" to "z"))
        assertEquals(from, mapOf("b" to "c"))
    }

    @Test
    @Tag("Easy")
    fun whoAreInBoth() {
        assertEquals(
            emptyList<String>(),
            whoAreInBoth(emptyList(), emptyList())
        )
        assertEquals(
            listOf("Marat"),
            whoAreInBoth(listOf("Marat", "Mikhail"), listOf("Marat", "Kirill"))
        )
        assertEquals(
            emptyList<String>(),
            whoAreInBoth(listOf("Marat", "Mikhail"), listOf("Sveta", "Kirill"))
        )
    }

    @Test
    @Tag("Normal")
    fun mergePhoneBooks() {
        assertEquals(
            mapOf("Emergency" to "112"),
            mergePhoneBooks(
                mapOf("Emergency" to "112"),
                mapOf("Emergency" to "112")
            )
        )
        assertEquals(
            mapOf("Emergency" to "112", "Police" to "02"),
            mergePhoneBooks(
                mapOf("Emergency" to "112"),
                mapOf("Emergency" to "112", "Police" to "02")
            )
        )
        assertEquals(
            mapOf("Emergency" to "112, 911", "Police" to "02"),
            mergePhoneBooks(
                mapOf("Emergency" to "112"),
                mapOf("Emergency" to "911", "Police" to "02")
            )
        )
        assertEquals(
            mapOf("Emergency" to "112, 911", "Fire department" to "01", "Police" to "02"),
            mergePhoneBooks(
                mapOf("Emergency" to "112", "Fire department" to "01"),
                mapOf("Emergency" to "911", "Police" to "02")
            )
        )
    }

    @Test
    @Tag("Normal")
    fun averageStockPrice() {
        assertEquals(
            mapOf<String, Double>(),
            averageStockPrice(listOf())
        )
        assertEquals(
            mapOf("MSFT" to 100.0, "NFLX" to 40.0),
            averageStockPrice(listOf("MSFT" to 100.0, "NFLX" to 40.0))
        )
        assertEquals(
            mapOf("MSFT" to 150.0, "NFLX" to 40.0),
            averageStockPrice(listOf("MSFT" to 100.0, "MSFT" to 200.0, "NFLX" to 40.0))
        )
        assertEquals(
            mapOf("MSFT" to 150.0, "NFLX" to 45.0),
            averageStockPrice(listOf("MSFT" to 100.0, "MSFT" to 200.0, "NFLX" to 40.0, "NFLX" to 50.0))
        )
    }

    @Test
    @Tag("Normal")
    fun findCheapestStuff() {
        assertNull(
            findCheapestStuff(
                mapOf("Мария" to ("печенье" to 20.0), "Орео" to ("печенье" to 100.0)),
                "торт"
            )
        )
        assertEquals(
            "Мария",
            findCheapestStuff(
                mapOf("Мария" to ("печенье" to 20.0), "Орео" to ("печенье" to 100.0)),
                "печенье"
            )
        )
    }

    @Test
    @Tag("Normal")
    fun canBuildFrom() {
        assertFalse(canBuildFrom(emptyList(), "foo"))
        assertTrue(canBuildFrom(listOf('a', 'b', 'o'), "baobab"))
        assertFalse(canBuildFrom(listOf('a', 'm', 'r'), "Marat"))
        assertTrue(canBuildFrom(listOf('G'), "g"))
        assertTrue(canBuildFrom(listOf('W', 'a', 'a', 'a', 'a', 'w'), "Waaaaw"))
    }

    @Test
    @Tag("Normal")
    fun extractRepeats() {
        assertEquals(
            emptyMap<String, Int>(),
            extractRepeats(emptyList())
        )
        assertEquals(
            mapOf("a" to 2),
            extractRepeats(listOf("a", "b", "a"))
        )
        assertEquals(
            emptyMap<String, Int>(),
            extractRepeats(listOf("a", "b", "c"))
        )
    }

    @Test
    @Tag("Normal")
    fun hasAnagrams() {
        assertFalse(hasAnagrams(emptyList()))
        assertTrue(hasAnagrams(listOf("рот", "свет", "тор")))
        assertFalse(hasAnagrams(listOf("рот", "свет", "код", "дверь")))
    }

    @Test
    @Tag("Hard")
    fun propagateHandshakes() {
        assertEquals(
            mapOf(
                "Marat" to setOf("Mikhail", "Sveta"),
                "Sveta" to setOf("Mikhail"),
                "Mikhail" to setOf()
            ),
            propagateHandshakes(
                mapOf(
                    "Marat" to setOf("Sveta"),
                    "Sveta" to setOf("Mikhail")
                )
            )
        )
        assertEquals(
            mapOf(
                "Marat" to setOf("Mikhail", "Sveta"),
                "Sveta" to setOf("Marat", "Mikhail"),
                "Mikhail" to setOf("Sveta", "Marat")
            ),
            propagateHandshakes(
                mapOf(
                    "Marat" to setOf("Mikhail", "Sveta"),
                    "Sveta" to setOf("Marat"),
                    "Mikhail" to setOf("Sveta")
                )
            )
        )
    }

    @Test
    @Tag("Hard")
    fun findSumOfTwo() {
        assertEquals(
            Pair(-1, -1),
            findSumOfTwo(emptyList(), 1)
        )
        assertEquals(
            Pair(0, 2),
            findSumOfTwo(listOf(1, 2, 3), 4)
        )
        assertEquals(
            Pair(-1, -1),
            findSumOfTwo(listOf(1, 2, 3), 6)
        )
        assertEquals(
            Pair(0, 1),
            findSumOfTwo(listOf(1, 0, 2), 1)
        )
        assertEquals(
            Pair(-1, -1),
            findSumOfTwo(listOf(1, 1), 0)
        )
        assertEquals(
            Pair(0, 1),
            findSumOfTwo(
                listOf(
                    1,
                    0,
                    1,
                    0,
                    2,
                    4
                ), 1
            )
        )
        assertEquals(
            Pair(638, 742),
            findSumOfTwo(
                listOf(
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    20238,
                    26999,
                    1,
                    1,
                    28184,
                    13349,
                    1,
                    40700,
                    15787,
                    48748,
                    0,
                    1,
                    36544,
                    1,
                    40700,
                    36060,
                    40700,
                    40700,
                    48450,
                    16537,
                    19528,
                    47267,
                    1,
                    40699,
                    12605,
                    9317,
                    7222,
                    24626,
                    40699,
                    40699,
                    40699,
                    40700,
                    1,
                    1,
                    40699,
                    40597,
                    40699,
                    27920,
                    40699,
                    40700,
                    23622,
                    40699,
                    40700,
                    21862,
                    40699,
                    0,
                    0,
                    6822,
                    40700,
                    25458,
                    0,
                    0,
                    9222,
                    39021,
                    40700,
                    42133,
                    40699,
                    0,
                    28941,
                    30522,
                    40700,
                    0,
                    49832,
                    40699,
                    1,
                    0,
                    0,
                    42751,
                    45513,
                    1,
                    40700,
                    40699,
                    1,
                    40699,
                    40699,
                    33600,
                    2106,
                    40699,
                    44702,
                    19086,
                    0,
                    0,
                    1,
                    40699,
                    1,
                    40700,
                    40591,
                    40699,
                    30646,
                    1,
                    37600,
                    33427,
                    1,
                    32364,
                    44363,
                    40699,
                    1,
                    7105,
                    7026,
                    20816,
                    40699,
                    40699,
                    40699,
                    22179,
                    1,
                    1,
                    40699,
                    1,
                    0,
                    48475,
                    40700,
                    40699,
                    40699,
                    1680,
                    6677,
                    16110,
                    42675,
                    40699,
                    23822,
                    10320,
                    44513,
                    38237,
                    20065,
                    1,
                    17960,
                    40700,
                    0,
                    12901,
                    40700,
                    40700,
                    0,
                    31040,
                    6119,
                    22124,
                    1,
                    1,
                    1,
                    44400,
                    40700,
                    0,
                    1,
                    48534,
                    42394,
                    0,
                    7070,
                    42225,
                    2149,
                    3441,
                    27580,
                    1,
                    40311,
                    40699,
                    39167,
                    40699,
                    23962,
                    17892,
                    40700,
                    40699,
                    40699,
                    0,
                    16662,
                    40699,
                    1,
                    40700,
                    40699,
                    0,
                    40699,
                    31599,
                    1,
                    1,
                    11484,
                    46659,
                    1,
                    40700,
                    5580,
                    0,
                    1,
                    1,
                    0,
                    45038,
                    45835,
                    8323,
                    27381,
                    30940,
                    19532,
                    36131,
                    26609,
                    24937,
                    40699,
                    23401,
                    5437,
                    12386,
                    40699,
                    1,
                    40699,
                    40700,
                    28417,
                    19630,
                    40699,
                    24927,
                    31740,
                    28923,
                    40700,
                    38262,
                    1,
                    0,
                    15229,
                    40700,
                    17883,
                    47263,
                    31811,
                    6599,
                    1,
                    1,
                    9121,
                    9003,
                    40699,
                    0,
                    43126,
                    40699,
                    40700,
                    40699,
                    40699,
                    27954,
                    40699,
                    40699,
                    45523,
                    1,
                    578,
                    40699,
                    40700,
                    40699,
                    1,
                    35915,
                    22385,
                    40699,
                    48177,
                    40699,
                    40699,
                    40700,
                    16028,
                    1,
                    40699,
                    40700,
                    21281,
                    1,
                    0,
                    40699,
                    9398,
                    40132,
                    14553,
                    40699,
                    1,
                    40699,
                    40699,
                    22068,
                    0,
                    43152,
                    33240,
                    40699,
                    24047,
                    47568,
                    36839,
                    40699,
                    40699,
                    8213,
                    40699,
                    40699,
                    0,
                    1,
                    0,
                    0,
                    30199,
                    40699,
                    0,
                    11649,
                    48090,
                    1,
                    630,
                    34858,
                    0,
                    0,
                    23261,
                    27316,
                    40699,
                    40699,
                    17284,
                    40699,
                    12486,
                    16971,
                    35591,
                    2980,
                    13475,
                    7258,
                    40700,
                    1,
                    2871,
                    1,
                    14749,
                    13455,
                    32715,
                    12076,
                    45258,
                    29039,
                    1,
                    40700,
                    0,
                    39036,
                    44714,
                    0,
                    40700,
                    25556,
                    31373,
                    16621,
                    40699,
                    0,
                    40699,
                    17498,
                    1,
                    12505,
                    40699,
                    33847,
                    0,
                    40699,
                    1,
                    40699,
                    28495,
                    1,
                    120,
                    40700,
                    40699,
                    46104,
                    40700,
                    43228,
                    40699,
                    40699,
                    49880,
                    40700,
                    1,
                    36117,
                    0,
                    1,
                    0,
                    39744,
                    9233,
                    0,
                    40699,
                    40364,
                    37542,
                    41660,
                    40700,
                    40699,
                    18020,
                    6751,
                    40699,
                    0,
                    0,
                    27141,
                    45345,
                    1,
                    40700,
                    14962,
                    0,
                    1,
                    31533,
                    1653,
                    40700,
                    40699,
                    40700,
                    1,
                    1,
                    8330,
                    1,
                    43189,
                    29686,
                    0,
                    1689,
                    4594,
                    40700,
                    9875,
                    40699,
                    0,
                    40700,
                    18800,
                    1,
                    2992,
                    0,
                    0,
                    36427,
                    1,
                    0,
                    48358,
                    5429,
                    40700,
                    40699,
                    40700,
                    29891,
                    41768,
                    40700,
                    1,
                    40699,
                    1,
                    0,
                    0,
                    20683,
                    1,
                    40699,
                    40699,
                    1,
                    1,
                    0,
                    40700,
                    1,
                    1,
                    49631,
                    34341,
                    7863,
                    40700,
                    40699,
                    40700,
                    1,
                    40700,
                    40699,
                    12701,
                    40700,
                    1,
                    0,
                    17909,
                    39105,
                    29875,
                    1,
                    4649,
                    22731,
                    37701,
                    0,
                    24544,
                    40700,
                    39187,
                    40699,
                    13465,
                    18971,
                    40699,
                    40699,
                    0,
                    19954,
                    40699,
                    36153,
                    40699,
                    43864,
                    43687,
                    40700,
                    1218,
                    1,
                    11857,
                    23316,
                    3805,
                    6813,
                    28296,
                    40461,
                    40700,
                    1,
                    40700,
                    26218,
                    40699,
                    1,
                    13886,
                    0,
                    40700,
                    33085,
                    16197,
                    40700,
                    0,
                    0,
                    48473,
                    40699,
                    40699,
                    40699,
                    26646,
                    16136,
                    22613,
                    27648,
                    0,
                    39910,
                    1,
                    1,
                    16728,
                    40894,
                    1,
                    1,
                    0,
                    1,
                    11385,
                    0,
                    10703,
                    40699,
                    1,
                    45105,
                    1,
                    40226,
                    40700,
                    5093,
                    17433,
                    8386,
                    0,
                    23210,
                    40700,
                    42172,
                    22613,
                    28917,
                    33737,
                    1,
                    40699,
                    0,
                    0,
                    1,
                    40700,
                    40699,
                    40700,
                    1,
                    0,
                    24843,
                    12571,
                    4457,
                    40699,
                    0,
                    40699,
                    1,
                    13978,
                    10873,
                    39539,
                    39280,
                    4424,
                    7273,
                    40699,
                    32228,
                    9284,
                    7265,
                    28517,
                    19213,
                    16559,
                    40700,
                    40700,
                    40700,
                    6151,
                    40700,
                    40700,
                    40700,
                    0,
                    44596,
                    36014,
                    43499,
                    1,
                    1,
                    0,
                    7688,
                    29748,
                    43354,
                    23943,
                    12626,
                    9229,
                    40699,
                    1,
                    1,
                    0,
                    0,
                    23364,
                    40699,
                    1,
                    0,
                    40700,
                    0,
                    31659,
                    45841,
                    40700,
                    1,
                    40700,
                    0,
                    0,
                    42001,
                    34289,
                    10760,
                    13634,
                    40700,
                    0,
                    2793,
                    22793,
                    46966,
                    40699,
                    40699,
                    1,
                    12611,
                    1,
                    33018,
                    40699,
                    6444,
                    26592,
                    17521,
                    37415,
                    40700,
                    40700,
                    0,
                    14350,
                    0,
                    0,
                    43328,
                    1,
                    10855,
                    48064,
                    40699,
                    30938,
                    44757,
                    1,
                    0,
                    42010,
                    49611,
                    15306,
                    0,
                    13361,
                    40699,
                    39946,
                    1,
                    40700,
                    29368,
                    1,
                    32533,
                    0,
                    0,
                    2327,
                    45239,
                    40699,
                    0,
                    40699,
                    40700,
                    21884,
                    40700,
                    7551,
                    1,
                    40700,
                    40700,
                    40700,
                    49177,
                    1,
                    29653,
                    40700,
                    40700,
                    0,
                    31247,
                    40699,
                    0,
                    38237,
                    39346,
                    40699,
                    40700,
                    48898,
                    40699,
                    40699,
                    2,
                    1,
                    13822,
                    12282,
                    16544,
                    31566,
                    13308,
                    41503,
                    35026,
                    47145,
                    37135,
                    40700,
                    1,
                    19445,
                    40699,
                    13796,
                    0,
                    49952,
                    0,
                    1,
                    8739,
                    1,
                    40700,
                    40700,
                    21504,
                    0,
                    1,
                    1,
                    1,
                    31788,
                    1,
                    11256,
                    25037,
                    40700,
                    30170,
                    40700,
                    33093,
                    40700,
                    40699,
                    15515,
                    40699,
                    49794,
                    40699,
                    0,
                    1,
                    40700,
                    40700,
                    40699,
                    39770,
                    25478,
                    26664,
                    1,
                    32534,
                    25936,
                    40699,
                    0,
                    46354,
                    1,
                    40700,
                    40699,
                    1,
                    0,
                    21008,
                    46521,
                    0,
                    0,
                    40699,
                    1,
                    14757,
                    0,
                    40700,
                    40700,
                    1659,
                    40700,
                    106,
                    5548,
                    37061,
                    40699,
                    0,
                    0,
                    40700,
                    4980,
                    49510,
                    16245,
                    1,
                    17697,
                    0,
                    18124,
                    40700,
                    28999,
                    0,
                    0,
                    30848,
                    40700,
                    41249,
                    40700,
                    1,
                    0,
                    41553,
                    0,
                    38687,
                    1,
                    40700,
                    40700,
                    1,
                    1,
                    1
                ), 57376
            )
        )

    }

    @Test
    @Tag("Impossible")
    fun bagPacking() {
        assertEquals(
            setOf("Кубок"),
            bagPacking(
                mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
                850
            )
        )
        assertEquals(
            emptySet<String>(),
            bagPacking(
                mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
                450
            )
        )
    }

    // TODO: map task tests
}
