package phm.example.movieranking.model.response

class BoxOfficeResult {
    var dailyBoxOfficeList: ArrayList<DailyBoxOfficeList>?=null
    var boxofficeType: String? = null
    var showRange: String? = null

    override fun toString(): String {
        return "ClassPojo [dailyBoxOfficeList = $dailyBoxOfficeList, boxofficeType = $boxofficeType, showRange = $showRange]"
    }
}