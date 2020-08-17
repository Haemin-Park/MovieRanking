package phm.example.movieranking.model.response

class DailyBoxOfficeList {
    var rnum: String? = null
    var audiCnt: String? = null
    var salesAcc: String? = null
    var scrnCnt: String? = null
    var rankInten: String? = null
    var salesShare: String? = null
    var movieNm: String? = null
    var salesAmt: String? = null
    var movieCd: String? = null
    var salesChange: String? = null
    var audiInten: String? = null
    var audiChange: String? = null
    var rankOldAndNew: String? = null
    var rank: String? = null
    var openDt: String? = null
    var salesInten: String? = null
    var showCnt: String? = null
    var audiAcc: String? = null

    override fun toString(): String {
        return "$rnum. $movieNm \n"
        //return "ClassPojo [rnum = $rnum, audiCnt = $audiCnt, salesAcc = $salesAcc, scrnCnt = $scrnCnt, rankInten = $rankInten, salesShare = $salesShare, movieNm = $movieNm, salesAmt = $salesAmt, movieCd = $movieCd, salesChange = $salesChange, audiInten = $audiInten, audiChange = $audiChange, rankOldAndNew = $rankOldAndNew, rank = $rank, openDt = $openDt, salesInten = $salesInten, showCnt = $showCnt, audiAcc = $audiAcc]"
    }

}