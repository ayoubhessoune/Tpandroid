package com.example.worldcup2022


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var teamRecyclerView: RecyclerView
    private lateinit var teamAdapter: TeamAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val teams = listOf(
            Team("Qatar", "https://4.bp.blogspot.com/-EnS1ML_Jk-Y/WB3DO7uhs5I/AAAAAAAAEWo/4h7ujZZs_v4fyqcstB5YtLwYMfXwSbfqACLcB/s600/Qatar.png", "Group A",
                listOf("Adckl"), "Felix Sanchez Bas "),
            Team("Ecuador", "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhxYcnLCbvH3dF-LGUzxBhAhse6O_d_7_kO-nmnPDgKWIbdxhaD_1d2mJA2sq_iXAVGK1vgMOZ_h_jJg1rertf4X0s3kE9oRUuYwoF4zFPZJ_SjSb20OmkoQbv_CoyJonQVcsI80J6pmqK0L3aRSyKVd_Jz3nrorRG6hLz21eiCOJsD1mIg2LlBQyJF/s600/ECU.png", "Group A", listOf(
                "Ads"),"Gustavo Alfaro"),
            Team("Senegal", "https://2.bp.blogspot.com/-Ulp4q2az-Ag/WCHRQjPa-8I/AAAAAAAAEZU/qD8Wi0EdFyQ_VUC7xFvadFcDXia3YhgPgCLcB/s600/Senegal.png", "Group A", listOf("Ads"), "Aliou Cissé"),
            Team("Netherlands", "https://3.bp.blogspot.com/-qM0-F4Gf-As/WyWsSkm4RdI/AAAAAAAAHis/gOlZc27SNlMqxnFC6rLSNFH02VLac6DxgCPcBGAYYCw/s600/ned.png", "Group A", listOf("Ads"), "Louis van Gaal") ,
            Team("England", "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgtPve6XfrICeZj_RLCPsfMXLhCaCnzCOryfg1MJupRHIOJL-JU9dJAqvUa3d89GWSy3ThDe3uFsXumxlykc5BlFOF14Ju1vQKqG-oGQ3JkL9oq9iQ7hrQWBK_SkToPHjGvrIneJDE9ISyNpapcgSYTO7sXqLu9OG4aQ8oMtT4Lj9O-ilPsIijqckOo/s600/ENG.png", "Group B", listOf("sd"),  "Gareth Southgate"),
            Team("Iran", "https://1.bp.blogspot.com/-B0JORkp3vXw/WB3DHxQZVFI/AAAAAAAAEVk/t4aXuq93tDY4hu9IbSs7a20lQu8Ng6DcwCLcB/s600/Iran.png", "Group B", listOf("sds"),"Dragan Skocic"),
            Team("Usa", "https://4.bp.blogspot.com/-vLH7YcZbF1s/WBn1mSr-yfI/AAAAAAAAESA/vnaB32onXkokLer4h21Hw3bK05FtGYYTgCLcB/s600/Amerika%2BSerikat.png", "Group B", listOf("dsd"),"Gregg Berhalter"),
            Team("Wales", "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjyE0wfrTXZ9rUCE2LbEHcQlvYW-pT6X4MZY6YgleYHPLfICGV_PMf7UFWavrDFpqZW_kDu_poY7IRongyvrmvVFqfRwUiv97xPaCyHFQt5-q3oUhOcmVyRLUEH8-WpGUIINv4XqoG1TIiTHqJhbiqnOumNnLZ85SOTFzSf7zsGVfjtNOQsU1SwPKS5/s600/WAL.png", "Group B", listOf("sds"),"Rob Page") ,
            Team("Argentina", "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhZjZZYZlp5TvwaMsc6On2gaPMouUxzIFpL8cjrtgdz-QUWDSmiD-gqn9ME7g4VIdWQo8fQ-qHiq03L0hb43go4OArxByGIvh6NCj4VQWYooBSonxWdUL5tBlU4rgAfQ-B1jfSGPAB3ZtiqgURJTpFupDlRSqyKZlnbKTCwMBc4DY5qi2hkGopulol6/s600/ARG.png", "Group C", listOf("sf"),"Lionel Scaloni"),
            Team("Saudi Arabia", "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEigxPTO1-cnxyANAWZotABcF7kbgGvXkZWYMDvVCtrNh4ZK7CR2GV5BIRSyodAA741o0JFUpXtBqA1HEAv4MhPrFYHkzWzuFrVQzkpbD-EWDpii_KNYqUfipMYzMDVO4oaqOMpLZl6Ae0bWW91rRAkAGhdRtsEBws_YcTHpjAsyKjFRodAoyDGQUZfk/s600/KSA.png", "Group C", listOf("sfsf"),"Hervé Renard"),
            Team("Mexico", "https://2.bp.blogspot.com/--7S8OZwMjuw/WBn1tZY9o4I/AAAAAAAAETk/cIpRQ7vn00MWAWrT_SUbPlrI-aKBAkrdwCLcB/s600/Meksiko.png", "Group C", listOf("sf"),"Gerardo Martino") ,
            Team("Poland", "https://2.bp.blogspot.com/-3n0ox3FebQ4/WyWsUDG91RI/AAAAAAAAHi0/PeWipDBQC80Ka7WbaNTPh60KOFTQ7iZCACPcBGAYYCw/s600/pol.png", "Group C", listOf("sff") ,"Czeslaw Michniewicz") ,
            Team("France", "https://2.bp.blogspot.com/-M9as6mpwXZw/W1URVMr0_YI/AAAAAAAAH28/ADy1RScx8jcmgsffR4yoPCbyIhC-pG4wgCLcBGAs/s0/fra.png", "Group D", listOf("sf"),"Didier Deschamps"),
            Team("Australia", "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiwuxyrFixosn0Hc7uh6nHF3KkalamlEkziBIPJocYA3Xq04iWEXWL8QfwE1_dhfa-1BX1tzWX1Q2dPD4ocfG_SGZKeagpq8YNr4jFL2k9Ccscx-XoSGXEjt3dtfu4ijN56S8M-KKf1wJe0IxyOUZ8YtbRZUY3utT32Kpe9lI_iFPnWustycjqBAWZu/s0/AUS.png", "Group D", listOf("sfsf"),"Graham Arnold "),
            Team("Denmark", "https://1.bp.blogspot.com/-pYtu_BS1kPw/WyWr9kYEETI/AAAAAAAAHjo/Vzzh482wd8kxhoYCAxjkMKdrWoaqkhdgwCPcBGAYYCw/s0/den.png", "Group D", listOf("sf"),"Kasper Hjulmand") ,
            Team("Tunisia", "https://1.bp.blogspot.com/-_yR_6CcxCmc/WCHYadeAefI/AAAAAAAAEcA/rfhyGGzelkA5a0Wk2NIqrQ0RxHscjZwawCLcB/s0/Tunisia.png", "Group D", listOf("sff") ,"Jalel Kadri"),
            Team("Spain", "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEghY5H9D5BnBd5Qr9rqETfBd968AbeitymfgEMUABPpzc928c1UviSWzQ_hdFg2aMpWZ_Yq5AH5VyyzEYGCBHG7xntl9xRSkqiDPZ6fH7sWOFTpTtgd-lRvgj8HFHO8HfIvqWfcRD_L_GLDD1qV2CRIIGZpfldT3JRn5pFT0a626fMEMET6OtfqdNYb/s1600/ESP.png", "Group E",
                listOf("Adckl"), "Luis Enrique"),
            Team("Costa rica", "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEi3pYbPqc6Wsy_PHJ4pLwn4aMk1kEugKMuoheNOMJKcyNHQHF0DXp2X2r1-RM6EZWLMzERtuczWtBiCYuosFgDHl9KSAuL8nZ1mo0fUccnJGSVa5MFiIw63RCblVek6OO3GbPJnDmk-Ao-I8jn05f_HrY3IuzVzVxF7QfwN6CAtLyNjLqQSJl3A_AiC/s0/CRC.png", "Group E", listOf(
                "Ads"),"Luis Fernando Suárez"),
            Team("Germany", "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiPutmlJ-NlyybKIzNVDNmNcOGfsOUAI02zNtN7m4JsWIwZ2MYAlndwBEpumlMhHnTtCt7XNNPz_oYjDrmiHv8RpWxwRUmMJk6c5uA8C1DTF8M10hvpMeaVrBHkmrMn_ElSIFS_zsx22cb86c1Gc-INupfIEzSgQvrveSrMBaAEUPrhcVhE4IJ072Uy/s0/GER.png", "Group E", listOf("Ads"), "Hans-Dieter Flick"),
            Team("Japan", "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjxEiVaJTaAO-6oSxOg3hnw3sz1EZs56OAgRojvzuUOR3vlTD31vVdK5gLbEADCpbrNq2Qh2fpw4W2PY9KbtE3L88t57Kx4378qaSgnoSapckSz5BXolx_pM_sGDXyzvsmMNJ_FPxI6jDyFcA1WYvb88lOjW7tr0azjEamSeJy1Z0VvXxs0F_rCkeKN/s0/JPN.png", "Group E", listOf("Ads"), "Hajime Moriyasu") ,
            Team("Belgium", "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjA9jgw6vxepKx7kTdjwY_XqJo68oOG-yVinQdG9UDa6reaSCD37g9cfsY4-JBnoWszEC2MyOZ9xZ7TgxTwHoCn9xTIOyMH1cnhSCTxetc3d-Vk-7rbtJH3gqMXjAN8D4CMS_q1NZ2YCvJpMnhOJUQUEtR3Jsu7V8SX6czJX5aU9jTfIQ7diuGBoOqe/s0/BEL.png", "Group F", listOf("sd"),  "Roberto Martínez"),
            Team("Canada", "https://1.bp.blogspot.com/-k0SlLGLmAq8/WBn1q65FkZI/AAAAAAAAETA/uQMwjGIlEzspgkZSx-_4Yg0k5mrymhODQCLcB/s0/Kanada.png", "Group F", listOf("sds"),"John Herdman "),
            Team("Morocco", "https://4.bp.blogspot.com/-yNbag62P5kI/WCHPR9R1O0I/AAAAAAAAEYc/OhfZ2zetvxordEFgN7F1y6mwSOlKtC62QCLcB/s0/Maroko.png", "Group F", listOf("dsd"),"Walid Regragui"),
            Team("Croatia", "https://2.bp.blogspot.com/-0klEPIDYy9U/WyQko0zNQLI/AAAAAAAAHgg/gSgv7-2iBbwkhFZYFh3Ym-OqiqB6S2zgQCLcBGAs/s0/cro.png", "Group F", listOf("sds"),"Zlatko Dalic") ,
            Team("Brazil", "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhMV3CKisREzNMzhJMsT-40NwltqkNLl1dXnDMLWeKyN5i1aTTQS-gGCNEDerrEawxnuU-MX8stQpsUhfMiO52Z0ndMdSNEdkJywaC-T3T43RUpBhMmYycxQvYY5pQAkk_7_a7IDWcyCT-VPxhaU7KHQhIGQhWiSE3JfCIDCLwzMlJG7z-2WEAF7E_1/s0/BRA.png", "Group G", listOf("sf"),"Tite"),
            Team("Serbia", "https://2.bp.blogspot.com/-aH9jatF0UK0/WyWsY7lHOqI/AAAAAAAAHjM/Uh8g9Drpk-EjpQirW50cPSo7ZlYzhKEwACPcBGAYYCw/s0/srb.png", "Group G", listOf("sfsf"),"Dragan Stojkovic"),
            Team("Switzerland", "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgMlTXjVQz3qs8d9QrFQh65VNgXOuUXCOJEAHGNs3i5rS0vwMDP37k_v5dTWRyJx5mP7KxaKD2d4OZQQOV8n_LX6ODb2ihnOc5XgHF57zqDXhfF87WLJo9o1U421kzyfe6QEgOLK-b5yf_qpySHGvahJcFMglHE1CSKm3riy0YBw9n9lw_cc8ltw09y/s0/SUI.png", "Group G", listOf("sf"),"Murat Yakin") ,
            Team("Cameroon", "https://4.bp.blogspot.com/-uqyw9cAwkRM/WCHTBGm3ZRI/AAAAAAAAEZ4/oY8cJQLkKukRxNFjEb9FtyBNrnj0N50VQCLcB/s0/Kamerun.png", "Group G", listOf("sff") ,"Rigobert Song") ,
            Team("Portugal", "https://3.bp.blogspot.com/-GGAPkXEJplc/WyWsUa85bMI/AAAAAAAAHjo/0IvanMdC79okNgT_D2RvKBP4eVzC0IIMgCPcBGAYYCw/s0/por.png", "Group H", listOf("sf"),"Fernando Santos"),
            Team("Ghana", "https://1.bp.blogspot.com/-ntBVRxOL6OU/WCHRNoaZUmI/AAAAAAAAEYs/NOyPQLRrukQGcHbarVD5KbedWvC5o2uxwCLcB/s0/Ghana.png", "Group H", listOf("sfsf"),"Otto Addo"),
            Team("Uruguay","https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjfkdOH4CWGqsqPKX2DTd3x0ezBTr_cyS0n10hFbgfpZWg5EKzFTNFSEhotztNiGNSmyGPJNS9CKVxswG1IJcdP7lDvN_HsXglW71e_q7rhZQWW1QsS7QqpLpZAtZ2LL8rW15jRtZosJvwXzTVv7YIoAWW2Lo9I1BQALsJ9z5hV1CNXYYNrwPkidKzF/s0/URU.png", "Group H", listOf("sf"),"Diego Alonso") ,
            Team("South Korea", "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgo52ddljzm1nOIPBJS0NWQxaRV363-Yi6paT1IKgbmY7nxtDY-jgMbH0-KRfYC3mKb5BSJsML441zN0dV-BmNzzgn0zqXgkNXtbGNqWmKBO1u6N41JluAoufYNQ4zoaKNGgo63CgmIYtKoOyZrKeKjGzo0DEYVMgRmQw3Y3j4tjSKfKLDeejcB0pPi/s0/KOR.png", "Group H", listOf("sff") ,"Paulo Bento")


        )

        teamRecyclerView = findViewById(R.id.team_recycler_view)
        teamAdapter = TeamAdapter(teams)

        teamRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = teamAdapter
        }
    }
}
