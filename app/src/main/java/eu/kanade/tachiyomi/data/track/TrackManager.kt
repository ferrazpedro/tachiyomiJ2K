package eu.kanade.tachiyomi.data.track

import android.content.Context
import eu.kanade.tachiyomi.data.track.anilist.Anilist
import eu.kanade.tachiyomi.data.track.bangumi.Bangumi
import eu.kanade.tachiyomi.data.track.kavita.Kavita
import eu.kanade.tachiyomi.data.track.kitsu.Kitsu
import eu.kanade.tachiyomi.data.track.komga.Komga
import eu.kanade.tachiyomi.data.track.mangaupdates.MangaUpdates
import eu.kanade.tachiyomi.data.track.myanimelist.MyAnimeList
import eu.kanade.tachiyomi.data.track.shikimori.Shikimori
import eu.kanade.tachiyomi.data.track.suwayomi.Suwayomi

class TrackManager(
    context: Context,
) {
    companion object {
        const val MYANIMELIST = 1
        const val ANILIST = 2
        const val KITSU = 3
        const val SHIKIMORI = 4
        const val BANGUMI = 5
        const val KOMGA = 6
        const val MANGA_UPDATES = 7
        const val KAVITA = 8
        const val SUWAYOMI = 9
    }

    val myAnimeList = MyAnimeList(context, MYANIMELIST)
    val aniList = Anilist(context, ANILIST)
    val kitsu = Kitsu(context, KITSU)
    val shikimori = Shikimori(context, SHIKIMORI)
    val bangumi = Bangumi(context, BANGUMI)
    val komga = Komga(context, KOMGA)
    val mangaUpdates = MangaUpdates(context, MANGA_UPDATES)
    val kavita = Kavita(context, KAVITA)
    val suwayomi = Suwayomi(context, SUWAYOMI)

    val services = listOf(myAnimeList, aniList, kitsu, shikimori, bangumi, komga, mangaUpdates, kavita, suwayomi)

    fun getService(id: Int) = services.find { it.id == id }

    fun hasLoggedServices() = services.any { it.isLogged }
}
