package com.ewa.api.mock

import com.ewa.api.Book
import com.ewa.api.BookApi
import com.ewa.api.R

internal class BookApiMock : BookApi {

    companion object {
        private var loadCount = 0
    }

    override fun loadBooksApi(key: String, language: String): List<Book> {
        if (key != "d7447d40–d250-11ed-b16f-0800200c9a66") throw Exception("Invalid api key")

        loadCount += 1
        if (loadCount % 7 == 0) throw Exception("500 error code")

        if (!language.equals("en", ignoreCase = true)) return emptyList()

        Thread.sleep(2000)

        return listOf(
            Book(
                id = "Nineteen Eighty-Four",
                title = "Nineteen Eighty-Four",
                image = R.drawable.nef,
                author = null,
                text = """Nineteen Eighty-Four (also published as 1984) is a dystopian social science fiction novel and cautionary tale by English writer George Orwell. It was published on 8 June 1949 by Secker & Warburg as Orwell's ninth and final book completed in his lifetime. Thematically, it centres on the consequences of totalitarianism, mass surveillance and repressive regimentation of people and behaviours within society.[2][3] Orwell, a democratic socialist, modelled the authoritarian state in the novel on Stalinist Russia and Nazi Germany.[2][3][4] More broadly, the novel examines the role of truth and facts within societies and the ways in which they can be manipulated.

The story takes place in an imagined future in the year 1984, when much of the world is in perpetual war. Great Britain, now known as Airstrip One, has become a province of the totalitarian superstate Oceania, which is led by Big Brother, a dictatorial leader supported by an intense cult of personality manufactured by the Party's Thought Police. Through the Ministry of Truth, the Party engages in omnipresent government surveillance, historical negationism, and constant propaganda to persecute individuality and independent thinking.[5]

The protagonist, Winston Smith, is a diligent mid-level worker at the Ministry of Truth who secretly hates the Party and dreams of rebellion. He keeps a forbidden diary and begins a relationship with his colleague Julia, and they learn about a shadowy resistance group called the Brotherhood. However, their contact with the Brotherhood turns out to be a Party agent, and Smith is arrested. He is subjected to months of psychological manipulation and torture by the Ministry of Love and is released once he has come to love Big Brother.

Nineteen Eighty-Four has become a classic literary example of political and dystopian fiction. It also popularised the term "Orwellian" as an adjective, with many terms used in the novel entering common usage, including "Big Brother", "doublethink", "Thought Police", "thoughtcrime", "Newspeak", and "2 + 2 = 5". Parallels have been drawn between the novel's subject matter and real life instances of totalitarianism, mass surveillance, and violations of freedom of expression among other themes.[6][7][8] Orwell described his book as a "satire,"[9] and a display of the "perversions to which a centralised economy is liable," while also stating he believed "that something resembling it could arrive."[9] Time included the novel on its list of the 100 best English-language novels from 1923 to 2005,[10] and it was placed on the Modern Library's 100 Best Novels list, reaching number 13 on the editors' list and number 6 on the readers' list.[11] In 2003, it was listed at number eight on The Big Read survey by the BBC.[12]"""
            ),

            Book(
                id = "Crime and Punishment",
                title = "Crime and Punishment",
                author = "Fyodor Dostoevsky",
                image = R.drawable.crime,
                text = """Crime and Punishment (pre-reform Russian: Преступленіе и наказаніе; post-reform Russian: Преступление и наказание, tr. Prestupléniye i nakazániye, IPA: [prʲɪstʊˈplʲenʲɪje ɪ nəkɐˈzanʲɪje]) is a novel by the Russian author Fyodor Dostoevsky. It was first published in the literary journal The Russian Messenger in twelve monthly installments during 1866.[1] It was later published in a single volume. It is the second of Dostoevsky's full-length novels following his return from ten years of exile in Siberia. Crime and Punishment is considered the first great novel of his mature period of writing.[2] The novel is often cited as one of the supreme achievements in world literature.[3][4][5][6]

Crime and Punishment follows the mental anguish and moral dilemmas of Rodion Raskolnikov, an impoverished ex-student in Saint Petersburg who plans to kill an unscrupulous pawnbroker, an old woman who stores money and valuable objects in her flat. He theorises that with the money he could liberate himself from poverty and go on to perform great deeds, and seeks to convince himself that certain crimes are justifiable if they are committed in order to remove obstacles to the higher goals of 'extraordinary' men. Once the deed is done, however, he finds himself racked with confusion, paranoia, and disgust. His theoretical justifications lose all their power as he struggles with guilt and horror and confronts both the internal and external consequences of his deed."""
            ),

            Book(
                id = "book_123",
                title = "The Brothers Karamazov",
                author = "Fyodor Dostoevsky",
                image = R.drawable.brothers,
                text = """The Brothers Karamazov (Russian: Братья Карамазовы, Brat'ya Karamazovy, pronounced [ˈbratʲjə kərɐˈmazəvɨ]), also translated as The Karamazov Brothers, is the last novel by Russian author Fyodor Dostoevsky. Dostoevsky spent nearly two years writing The Brothers Karamazov, which was published as a serial in The Russian Messenger from January 1879 to November 1880. Dostoevsky died less than four months after its publication.

Set in 19th-century Russia, The Brothers Karamazov is a passionate philosophical novel that enters deeply into questions of God, free will, and morality. It is a theological drama dealing with problems of faith, doubt, and reason in the context of a modernizing Russia, with a plot that revolves around the subject of patricide. Dostoevsky composed much of the novel in Staraya Russa, which inspired the main setting.[1] It has been acclaimed as one of the supreme achievements in world literature."""
            ),

            Book(
                id = "The Idiot",
                title = "The Idiot",
                author = "Fyodor Dostoevsky",
                image = R.drawable.idiot,
                text = """The Idiot (pre-reform Russian: Идіотъ; post-reform Russian: Идиот, tr. Idiót) is a novel by the 19th-century Russian author Fyodor Dostoevsky. It was first published serially in the journal The Russian Messenger in 1868–69.

The title is an ironic reference to the central character of the novel, Prince Lev Nikolayevich Myshkin, a young man whose goodness, open-hearted simplicity and guilelessness lead many of the more worldly characters he encounters to mistakenly assume that he lacks intelligence and insight. In the character of Prince Myshkin, Dostoevsky set himself the task of depicting "the positively good and beautiful man."[1] The novel examines the consequences of placing such a singular individual at the centre of the conflicts, desires, passions and egoism of worldly society, both for the man himself and for those with whom he becomes involved.

Joseph Frank describes The Idiot as "the most personal of all Dostoevsky's major works, the book in which he embodies his most intimate, cherished, and sacred convictions."[2] It includes descriptions of some of his most intense personal ordeals, such as epilepsy and mock execution, and explores moral, spiritual and philosophical themes consequent upon them. His primary motivation in writing the novel was to subject his own highest ideal, that of true Christian love, to the crucible of contemporary Russian society.

The artistic method of conscientiously testing his central idea meant that the author could not always predict where the plot was going as he was writing. The novel has an awkward structure, and many critics have commented on its seemingly chaotic organization. According to Gary Saul Morson, "The Idiot violates every critical norm and yet somehow manages to achieve real greatness."[3] Dostoevsky himself was of the opinion that the experiment was not entirely successful, but the novel remained his favourite among his works. In a letter to Strakhov he wrote: "Much in the novel was written hurriedly, much is too diffuse and did not turn out well, but some of it did turn out well. I do not stand behind the novel, but I do stand behind the idea."[4]"""
            ),

            Book(
                id = "Demons (Dostoevsky novel)",
                title = "Demons (Dostoevsky novel)",
                author = "Fyodor Dostoevsky",
                image = R.drawable.demons,
                text = """Demons (pre-reform Russian: Бѣсы; post-reform Russian: Бесы, tr. Bésy, IPA: [ˈbʲe.sɨ]; sometimes also called The Possessed or The Devils) is a novel by Fyodor Dostoevsky, first published in the journal The Russian Messenger in 1871–72. It is considered one of the four masterworks written by Dostoevsky after his return from Siberian exile, along with Crime and Punishment (1866), The Idiot (1869), and The Brothers Karamazov (1880). Demons is a social and political satire, a psychological drama, and large-scale tragedy. Joyce Carol Oates has described it as "Dostoevsky's most confused and violent novel, and his most satisfactorily 'tragic' work."[1] According to Ronald Hingley, it is Dostoevsky's "greatest onslaught on Nihilism", and "one of humanity's most impressive achievements—perhaps even its supreme achievement—in the art of prose fiction."[2]

Demons is an allegory of the potentially catastrophic consequences of the political and moral nihilism that were becoming prevalent in Russia in the 1860s.[3] A fictional town descends into chaos as it becomes the focal point of an attempted revolution, orchestrated by master conspirator Pyotr Verkhovensky. The mysterious aristocratic figure of Nikolai Stavrogin—Verkhovensky's counterpart in the moral sphere—dominates the book, exercising an extraordinary influence over the hearts and minds of almost all the other characters. The idealistic, Western-influenced intellectuals of the 1840s, epitomized in the character of Stepan Verkhovensky (who is both Pyotr Verkhovensky's father and Nikolai Stavrogin's childhood teacher), are presented as the unconscious progenitors and helpless accomplices of the "demonic" forces that take possession of the town."""
            ),

            Book(
                id = "Hamnet Shakespeare",
                title = "Hamnet Shakespeare",
                author = null,
                image = R.drawable.hamlet,
                text = """Hamnet Shakespeare (baptised 2 February 1585 – buried 11 August 1596) was the only son of William Shakespeare and Anne Hathaway, and the fraternal twin of Judith Shakespeare.[1][2][3][4] He died aged 11. Some Shakespearean scholars speculate on the relationship between Hamnet and his father's later play Hamlet,[5] as well as on possible connections between Hamnet's death and the writing of King John, Romeo and Juliet, Julius Caesar, and Twelfth Night."""
            ),

            Book(
                id = "All Quiet on the Western Front",
                title = "All Quiet on the Western Front",
                author = null,
                image = R.drawable.front,
                text = """All Quiet on the Western Front (German: Im Westen nichts Neues, lit. 'Nothing New in the West') is a novel by Erich Maria Remarque, a German veteran of World War I. The book describes the German soldiers' extreme physical and mental trauma during the war as well as the detachment from civilian life felt by many upon returning home from the war.

The novel was first published in November and December 1928 in the German newspaper Vossische Zeitung and in book form in late January 1929. The book and its sequel, The Road Back (1930), were among the books banned and burned in Nazi Germany. All Quiet on the Western Front sold 2.5 million copies in 22 languages in its first 18 months in print.[1]

Three film adaptations of the book have been made, each of which was lauded. The 1930 American adaptation, directed by Lewis Milestone, won two Academy Awards. The 1979 British-American adaptation, a television film by Delbert Mann, won a Golden Globe Award and an Emmy Award. The 2022 German adaptation, directed by Edward Berger, won four Academy Awards."""
            ),

            Book(
                id = "Romeo and Juliet",
                title = "Romeo and Juliet",
                author = null,
                image = R.drawable.romeo,
                text = """Hamnet Shakespeare (baptised 2 February 1585 – buried 11 August 1596) was the only son of William Shakespeare and Anne Hathaway, and the fraternal twin of Judith Shakespeare.[1][2][3][4] He died aged 11. Some Shakespearean scholars speculate on the relationship between Hamnet and his father's later play Hamlet,[5] as well as on possible connections between Hamnet's death and the writing of King John, Romeo and Juliet, Julius Caesar, and Twelfth Night."""
            ),

            Book(
                id = "Shantaram",
                title = "Shantaram",
                author = "Gregory David Roberts",
                image = R.drawable.shantaram,
                text = """Shantaram is a 2003 novel by Gregory David Roberts, in which a convicted Australian bank robber and heroin addict escapes from Pentridge Prison and flees to India. The novel is commended by many for its vivid portrayal of life in Bombay in the early to late 1980s.

The novel is reportedly influenced by real events in the life of the author, though some claims made by Roberts are contested by others involved in the story."""
            ),

            Book(
                id = "Pride and Prejudice",
                title = "Pride and Prejudice",
                author = "Jane Austen",
                image = R.drawable.pride,
                text = """Pride and Prejudice is an 1813 novel of manners by Jane Austen. The novel follows the character development of Elizabeth Bennet, the dynamic protagonist of the book who learns about the repercussions of hasty judgments and comes to appreciate the difference between superficial goodness and actual goodness.

Mr Bennet, owner of the Longbourn estate in Hertfordshire, has five daughters, but his property is entailed and can only be passed to a male heir. His wife also lacks an inheritance, so his family faces becoming poor upon his death. Thus, it is imperative that at least one of the daughters marries well to support the others, which is a motivation that drives the plot.

Pride and Prejudice has consistently appeared near the top of lists of "most-loved books" among literary scholars and the reading public. It has become one of the most popular novels in English literature, with over 20 million copies sold, and has inspired many derivatives in modern literature.[1][2] For more than a century, dramatic adaptations, reprints, unofficial sequels, films, and TV versions of Pride and Prejudice have portrayed the memorable characters and themes of the novel, reaching mass audiences.[3]

"""
            ),

            Book(
                id = "The Great Gatsby",
                title = "The Great Gatsby",
                author = "F. Scott Fitzgerald",
                image = R.drawable.garsby,
                text = """The Great Gatsby is a 1925 novel by American writer F. Scott Fitzgerald. Set in the Jazz Age on Long Island, near New York City, the novel depicts first-person narrator Nick Carraway's interactions with mysterious millionaire Jay Gatsby and Gatsby's obsession to reunite with his former lover, Daisy Buchanan.

The novel was inspired by a youthful romance Fitzgerald had with socialite Ginevra King, and the riotous parties he attended on Long Island's North Shore in 1922. Following a move to the French Riviera, Fitzgerald completed a rough draft of the novel in 1924. He submitted it to editor Maxwell Perkins, who persuaded Fitzgerald to revise the work over the following winter. After making revisions, Fitzgerald was satisfied with the text, but remained ambivalent about the book's title and considered several alternatives. Painter Francis Cugat's cover art greatly impressed Fitzgerald, and he incorporated its imagery into the novel.

After its publication by Scribner's in April 1925, The Great Gatsby received generally favorable reviews, though some literary critics believed it did not equal Fitzgerald's previous efforts. Compared to his earlier novels, such as This Side of Paradise and The Beautiful and Damned, Gatsby was a commercial disappointment. It sold fewer than 20,000 copies by October, and Fitzgerald's hopes of a monetary windfall from the novel were unrealized. When the author died in 1940, he believed himself to be a failure and his work forgotten.

During World War II, the novel experienced an abrupt surge in popularity when the Council on Books in Wartime distributed free copies to American soldiers serving overseas. This new-found popularity launched a critical and scholarly re-examination, and the work soon became a core part of most American high school curricula and a part of American popular culture. Numerous stage and film adaptations followed in the subsequent decades.

Gatsby continues to attract popular and scholarly attention. Contemporary scholars emphasize the novel's treatment of social class, inherited versus self-made wealth, gender, race, and environmentalism, and its cynical attitude towards the American Dream. One persistent item of criticism is an allegation of antisemitic stereotyping. The Great Gatsby is widely considered to be a literary masterwork and a contender for the title of the Great American Novel."""
            ),


            )
    }

}