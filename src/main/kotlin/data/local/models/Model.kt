package data.local.models

import com.google.gson.annotations.SerializedName

data class DeitiesDTOItem(
    @SerializedName("id")
    val id: Int? = null, // 1
    @SerializedName("image_url")
    val imageUrl: String? = null, // 1sMon4gFLF8AY2WgAh2uCn7VJQXaLP2_l
    @SerializedName("name")
    val name: String? = null, // Shiva
    @SerializedName("sheet_name")
    val sheetName: String? = null // shiva
)

data class DeityItem(
    @SerializedName("audio_url")
    val audioUrl: String? = null, // 1iwkLtnuW-QOhFGYD9MHc4uO6EsMIJBkw
    @SerializedName("description")
    val description: String? = null, // Durga aarti
    @SerializedName("lyrics_english")
    val lyricsEnglish: String? = null, // Maa Durga AartiJai ambe gauri, maiya jai shyama gauriTumko nish-din dhyavat, hari brahma shivjiJai ambe gauri Maang sindoor virajat, tiko mrig-mad koUjjwal se dou naina, chandra vadan nikoJai ambe gauri Kanak samaan kalewar, raktaambar raajeRakt pushp gal-mala, kanthan par saajeJai ambe gauri Kehri vahan rajat, kharag khapar dhaariSur nar muni jan sevat, tinke dukh haariJai ambe gauri Kanan kundal shobhit, naas-agre motiKotik chandra divakar, sum rajat jyotiJai ambe gauri Shumbh ni-shumbh vidare, mahisha sur ghatiDhumra-vilochan naina, nish-din- mad matiJai ambe gauri Chandh mundh sangh-haare, shonit beej hareMadhu kaitabh dou maare, sur bhe heen kareJai ambe gauri Brahmani rudrani, tum kamla raniAagam nigam bakhani, tum shiv patraniJai ambe gauri Chon-sath yogini gavat, nritya karat bhaironBaajat taal mridanga, aur baajat damaroomarooJai ambe gauriTum ho jag ki maata, tum hi ho bhartaBhakto ki dukh harata, sukh sampati karataJai ambe gauri Bhuja chaar ati shobit, var mudra dhaariMan vaanchit phal pavat, sevat nar naariJai ambe gauri Kanchan thaal virajat, agar kapoor baatiShri maal-ketu me rajat, kotik ratan jyotiJai ambe gauri Shri ambe-ji-ki aaarti, jo koi nar gaaveKahat shivanand swami, sukh sampati paaveJai ambe gauri
    @SerializedName("lyrics_hindi")
    val lyricsHindi: String? = null, // जय अम्बे गौरी, मैया जय श्यामा गौरी।तुमको निशदिन ध्यावत, हरि ब्रह्मा शिव री।। जय अम्बे गौरी,...।मांग सिंदूर बिराजत, टीको मृगमद को।उज्ज्वल से दोउ नैना, चंद्रबदन नीको।। जय अम्बे गौरी,...।कनक समान कलेवर, रक्ताम्बर राजै।रक्तपुष्प गल माला, कंठन पर साजै।। जय अम्बे गौरी,...।केहरि वाहन राजत, खड्ग खप्परधारी।सुर-नर मुनिजन सेवत, तिनके दुःखहारी।। जय अम्बे गौरी,...।कानन कुण्डल शोभित, नासाग्रे मोती।कोटिक चंद्र दिवाकर, राजत समज्योति।। जय अम्बे गौरी,...।शुम्भ निशुम्भ बिडारे, महिषासुर घाती।धूम्र विलोचन नैना, निशिदिन मदमाती।। जय अम्बे गौरी,...।चण्ड-मुण्ड संहारे, शौणित बीज हरे।मधु कैटभ दोउ मारे, सुर भयहीन करे।। जय अम्बे गौरी,...।ब्रह्माणी, रुद्राणी, तुम कमला रानी।आगम निगम बखानी, तुम शिव पटरानी।। जय अम्बे गौरी,...।चौंसठ योगिनि मंगल गावैं, नृत्य करत भैरू।बाजत ताल मृदंगा, अरू बाजत डमरू।। जय अम्बे गौरी,...।तुम ही जग की माता, तुम ही हो भरता।भक्तन की दुःख हरता, सुख सम्पत्ति करता।। जय अम्बे गौरी,...।भुजा चार अति शोभित, खड्ग खप्परधारी।मनवांछित फल पावत, सेवत नर नारी।। जय अम्बे गौरी,...।कंचन थाल विराजत, अगर कपूर बाती।श्री मालकेतु में राजत, कोटि रतन ज्योति।। जय अम्बे गौरी,...।अम्बेजी की आरती जो कोई नर गावै।कहत शिवानंद स्वामी, सुख-सम्पत्ति पावै।। जय अम्बे गौरी,...।
    @SerializedName("name")
    val name: String? = null, // Durga
    @SerializedName("type")
    val type: String? = null, // aarti
    @SerializedName("youtube_link")
    val youtubeLink: Any? = null // null
)

data class HoroscopeItem(
    @SerializedName("date_group")
    val dateGroup: String? = null, // Mar-21 to Apr-20
    @SerializedName("id")
    val id: Int? = null, // 1
    @SerializedName("image_url")
    val imageUrl: String? = null, // 1sMon4gFLF8AY2WgAh2uCn7VJQXaLP2_aries
    @SerializedName("name")
    val name: String? = null, // Aries
    @SerializedName("sheet_name")
    val sheetName: String? = null // aries
)