package com.ewa.api.mock

import com.ewa.api.Book
import com.ewa.api.BookApi
import com.ewa.api.R

internal class BookApiMock : BookApi {

    companion object {
        private var loadCount = 0
        private const val VALID_API_KEY = "d7447d40–d250-11ed-b16f-0800200c9a66"
    }

    override suspend fun loadBooksApi(key: String, language: String): List<Book> {
        simulateNetworkDelay()
        validateApiKey(key)
        handleErrorSimulation()
        validateLanguage(language)
        return getAllBooks()
    }

    private fun validateApiKey(key: String) {
        if (key != VALID_API_KEY) {
            throw Exception("Invalid api key")
        }
    }

    private fun simulateNetworkDelay() {
        Thread.sleep(4000L)
    }

    private fun handleErrorSimulation() {
        loadCount += 1
        if (loadCount > 4) {
            throw Exception("500 error code")
        }
    }

    private fun validateLanguage(language: String) {
        if (language != "EN") throw Exception("500 unsupported language")
    }

    private fun getAllBooks(): List<Book> {
        return listOf(
            createNineteenEightyFour(),
            createCrimeAndPunishment(),
            createBrothersKaramazov(),
            createTheIdiot(),
            createDemons(),
            createHamnetShakespeare(),
            createAllQuietOnTheWesternFront(),
            createRomeoAndJuliet(),
            createShantaram(),
            createPrideAndPrejudice(),
            createTheGreatGatsby(),
            createToKillAMockingbird(),
            createTheCatcherInTheRye(),
            createLordOfTheFlies(),
            createAnimalFarm(),
            createTheHobbit(),
            createFahrenheit451(),
            createBraveNewWorld(),
            createTheAlchemist()
        )
    }

    // Books with images
    private fun createNineteenEightyFour() = Book(
        id = "nineteen_eighty_four",
        title = "Nineteen Eighty-Four",
        image = R.drawable.nef,
        author = null,
        text = """Nineteen Eighty-Four (also published as 1984) is a dystopian social science fiction novel and cautionary tale by English writer George Orwell. It was published on 8 June 1949 by Secker & Warburg as Orwell's ninth and final book completed in his lifetime. Thematically, it centres on the consequences of totalitarianism, mass surveillance and repressive regimentation of people and behaviours within society.

The story takes place in an imagined future in the year 1984, when much of the world is in perpetual war. Great Britain, now known as Airstrip One, has become a province of the totalitarian superstate Oceania, which is led by Big Brother, a dictatorial leader supported by an intense cult of personality manufactured by the Party's Thought Police. Through the Ministry of Truth, the Party engages in omnipresent government surveillance, historical negationism, and constant propaganda to persecute individuality and independent thinking.

The protagonist, Winston Smith, is a diligent mid-level worker at the Ministry of Truth who secretly hates the Party and dreams of rebellion. He keeps a forbidden diary and begins a relationship with his colleague Julia, and they learn about a shadowy resistance group called the Brotherhood. However, their contact with the Brotherhood turns out to be a Party agent, and Smith is arrested. He is subjected to months of psychological manipulation and torture by the Ministry of Love and is released once he has come to love Big Brother.

The novel explores themes of psychological manipulation, physical control, and the manipulation of truth and history. The Party's slogan "War is Peace, Freedom is Slavery, Ignorance is Strength" exemplifies the concept of doublethink, where contradictory beliefs are held simultaneously. The novel's depiction of a society where every aspect of life is controlled by the state, including language itself through Newspeak, serves as a powerful warning about the dangers of totalitarianism and the importance of preserving individual freedom and critical thinking.

Orwell's work was influenced by his experiences during the Spanish Civil War and his observations of totalitarian regimes in Nazi Germany and the Soviet Union under Stalin. The novel's impact on popular culture has been immense, with terms like "Big Brother," "thought police," and "doublethink" entering common usage. The novel continues to be relevant in discussions about privacy, surveillance, and the role of government in modern society."""
    )

    private fun createCrimeAndPunishment() = Book(
        id = "crime_and_punishment",
        title = "Crime and Punishment",
        author = "Fyodor Dostoevsky",
        image = R.drawable.crime,
        text = """Crime and Punishment is a novel by the Russian author Fyodor Dostoevsky. It was first published in the literary journal The Russian Messenger in twelve monthly installments during 1866. It was later published in a single volume. It is the second of Dostoevsky's full-length novels following his return from ten years of exile in Siberia. Crime and Punishment is considered the first great novel of his mature period of writing.

Crime and Punishment follows the mental anguish and moral dilemmas of Rodion Raskolnikov, an impoverished ex-student in Saint Petersburg who plans to kill an unscrupulous pawnbroker, an old woman who stores money and valuable objects in her flat. He theorises that with the money he could liberate himself from poverty and go on to perform great deeds, and seeks to convince himself that certain crimes are justifiable if they are committed in order to remove obstacles to the higher goals of 'extraordinary' men. Once the deed is done, however, he finds himself racked with confusion, paranoia, and disgust. His theoretical justifications lose all their power as he struggles with guilt and horror and confronts both the internal and external consequences of his deed.

The novel delves deeply into the psychology of its protagonist, exploring themes of guilt, redemption, and the nature of morality. Raskolnikov's theory of the "extraordinary man" who is above conventional morality is tested and ultimately shattered by the reality of his actions. The character of Sonya Marmeladova, a prostitute who becomes Raskolnikov's moral compass, represents the possibility of redemption through suffering and faith. The novel's exploration of poverty, social inequality, and the human capacity for both great evil and great good makes it one of the most profound psychological novels ever written.

Dostoevsky's own experiences with poverty, imprisonment, and near-execution deeply influenced the novel's themes and atmosphere. The novel's complex narrative structure, with its multiple perspectives and philosophical digressions, reflects Dostoevsky's belief in the importance of exploring the deepest recesses of the human soul. The novel continues to be studied for its insights into human psychology, morality, and the social conditions that can drive individuals to desperate acts."""
    )

    private fun createBrothersKaramazov() = Book(
        id = "the_brothers_karamazov",
        title = "The Brothers Karamazov",
        author = "Fyodor Dostoevsky",
        image = R.drawable.brothers,
        text = """The Brothers Karamazov is the last novel by Russian author Fyodor Dostoevsky. Dostoevsky spent nearly two years writing The Brothers Karamazov, which was published as a serial in The Russian Messenger from January 1879 to November 1880. Dostoevsky died less than four months after its publication.

Set in 19th-century Russia, The Brothers Karamazov is a passionate philosophical novel that enters deeply into questions of God, free will, and morality. It is a theological drama dealing with problems of faith, doubt, and reason in the context of a modernizing Russia, with a plot that revolves around the subject of patricide. Dostoevsky composed much of the novel in Staraya Russa, which inspired the main setting. It has been acclaimed as one of the supreme achievements in world literature.

The novel centers around the three Karamazov brothers: Dmitri, the passionate and impulsive eldest; Ivan, the intellectual and atheistic middle brother; and Alyosha, the youngest, who is a novice monk and represents faith and goodness. Their father, Fyodor Pavlovich Karamazov, is a dissolute and selfish man who has neglected his sons. The complex relationships between the brothers and their father, along with their competing philosophies and moral systems, create a rich tapestry of human experience and philosophical inquiry.

The novel explores profound questions about the existence of God, the nature of evil, and the possibility of redemption. The famous "Grand Inquisitor" chapter, in which Ivan tells Alyosha a parable about Christ's return to earth during the Spanish Inquisition, is considered one of the most powerful critiques of organized religion ever written. The novel's exploration of the human condition, with its emphasis on suffering, love, and the search for meaning, has made it a cornerstone of world literature and a source of endless philosophical discussion."""
    )

    private fun createTheIdiot() = Book(
        id = "the_idiot",
        title = "The Idiot",
        author = "Fyodor Dostoevsky",
        image = R.drawable.idiot,
        text = """The Idiot is a novel by the 19th-century Russian author Fyodor Dostoevsky. It was first published serially in the journal The Russian Messenger in 1868–69.

The title is an ironic reference to the central character of the novel, Prince Lev Nikolayevich Myshkin, a young man whose goodness, open-hearted simplicity and guilelessness lead many of the more worldly characters he encounters to mistakenly assume that he lacks intelligence and insight. In the character of Prince Myshkin, Dostoevsky set himself the task of depicting "the positively good and beautiful man." The novel examines the consequences of placing such a singular individual at the centre of the conflicts, desires, passions and egoism of worldly society, both for the man himself and for those with whom he becomes involved."""
    )

    private fun createDemons() = Book(
        id = "demons",
        title = "Demons (Dostoevsky novel)",
        author = "Fyodor Dostoevsky",
        image = R.drawable.demons,
        text = """Demons is a novel by Fyodor Dostoevsky, first published in the journal The Russian Messenger in 1871–72. It is considered one of the four masterworks written by Dostoevsky after his return from Siberian exile, along with Crime and Punishment (1866), The Idiot (1869), and The Brothers Karamazov (1880). Demons is a social and political satire, a psychological drama, and large-scale tragedy.

Demons is an allegory of the potentially catastrophic consequences of the political and moral nihilism that were becoming prevalent in Russia in the 1860s. A fictional town descends into chaos as it becomes the focal point of an attempted revolution, orchestrated by master conspirator Pyotr Verkhovensky. The mysterious aristocratic figure of Nikolai Stavrogin—Verkhovensky's counterpart in the moral sphere—dominates the book, exercising an extraordinary influence over the hearts and minds of almost all the other characters."""
    )

    private fun createHamnetShakespeare() = Book(
        id = "hamnet_shakespeare",
        title = "Hamnet Shakespeare",
        author = null,
        image = R.drawable.hamlet,
        text = """Hamnet Shakespeare was the only son of William Shakespeare and Anne Hathaway, and the fraternal twin of Judith Shakespeare. He died aged 11. Some Shakespearean scholars speculate on the relationship between Hamnet and his father's later play Hamlet, as well as on possible connections between Hamnet's death and the writing of King John, Romeo and Juliet, Julius Caesar, and Twelfth Night."""
    )

    private fun createAllQuietOnTheWesternFront() = Book(
        id = "all_quiet_on_the_western_front",
        title = "All Quiet on the Western Front",
        author = null,
        image = R.drawable.front,
        text = """All Quiet on the Western Front is a novel by Erich Maria Remarque, a German veteran of World War I. The book describes the German soldiers' extreme physical and mental trauma during the war as well as the detachment from civilian life felt by many upon returning home from the war.

The novel was first published in November and December 1928 in the German newspaper Vossische Zeitung and in book form in late January 1929. The book and its sequel, The Road Back (1930), were among the books banned and burned in Nazi Germany. All Quiet on the Western Front sold 2.5 million copies in 22 languages in its first 18 months in print."""
    )

    private fun createRomeoAndJuliet() = Book(
        id = "romeo_and_juliet",
        title = "Romeo and Juliet",
        author = null,
        image = R.drawable.romeo,
        text = """Romeo and Juliet is a tragedy written by William Shakespeare early in his career about the romance between two Italian youths from feuding families. It was among Shakespeare's most popular plays during his lifetime and, along with Hamlet, is one of his most frequently performed plays. Today, the title characters are regarded as archetypal young lovers."""
    )

    private fun createShantaram() = Book(
        id = "shantaram",
        title = "Shantaram",
        author = "Gregory David Roberts",
        image = R.drawable.shantaram,
        text = """Shantaram is a 2003 novel by Gregory David Roberts, in which a convicted Australian bank robber and heroin addict escapes from Pentridge Prison and flees to India. The novel is commended by many for its vivid portrayal of life in Bombay in the early to late 1980s.

The novel is reportedly influenced by real events in the life of the author, though some claims made by Roberts are contested by others involved in the story."""
    )

    private fun createPrideAndPrejudice() = Book(
        id = "pride_and_prejudice",
        title = "Pride and Prejudice",
        author = "Jane Austen",
        image = R.drawable.pride,
        text = """Pride and Prejudice is an 1813 novel of manners by Jane Austen. The novel follows the character development of Elizabeth Bennet, the dynamic protagonist of the book who learns about the repercussions of hasty judgments and comes to appreciate the difference between superficial goodness and actual goodness.

Mr Bennet, owner of the Longbourn estate in Hertfordshire, has five daughters, but his property is entailed and can only be passed to a male heir. His wife also lacks an inheritance, so his family faces becoming poor upon his death. Thus, it is imperative that at least one of the daughters marries well to support the others, which is a motivation that drives the plot."""
    )

    private fun createTheGreatGatsby() = Book(
        id = "the_great_gatsby",
        title = "The Great Gatsby",
        author = "F. Scott Fitzgerald",
        image = R.drawable.garsby,
        text = """The Great Gatsby is a 1925 novel by American writer F. Scott Fitzgerald. Set in the Jazz Age on Long Island, near New York City, the novel depicts first-person narrator Nick Carraway's interactions with mysterious millionaire Jay Gatsby and Gatsby's obsession to reunite with his former lover, Daisy Buchanan.

The novel was inspired by a youthful romance Fitzgerald had with socialite Ginevra King, and the riotous parties he attended on Long Island's North Shore in 1922. Following a move to the French Riviera, Fitzgerald completed a rough draft of the novel in 1924. He submitted it to editor Maxwell Perkins, who persuaded Fitzgerald to revise the work over the following winter."""
    )

    private fun createToKillAMockingbird() = Book(
        id = "to_kill_a_mockingbird",
        title = "To Kill a Mockingbird",
        author = "Harper Lee",
        image = R.drawable.killerm,
        text = """To Kill a Mockingbird is a novel by the American author Harper Lee. It was published in 1960 and was instantly successful. In the United States, it is widely read in high schools and middle schools. To Kill a Mockingbird has become a classic of modern American literature, winning the Pulitzer Prize.

The plot and characters are loosely based on Lee's observations of her family, her neighbors and an event that occurred near her hometown of Monroeville, Alabama, in 1936, when she was 10 years old.

The story is told by the six-year-old Jean Louise Finch. The novel is renowned for its warmth and humor, despite dealing with the serious issues of rape and racial inequality. The narrator's father, Atticus Finch, has served as a moral hero for many readers and as a model of integrity for lawyers."""
    )

    private fun createTheCatcherInTheRye() = Book(
        id = "the_catcher_in_the_rye",
        title = "The Catcher in the Rye",
        author = "J.D. Salinger",
        image = R.drawable.rye,
        text = """The Catcher in the Rye is a novel by J. D. Salinger, partially published in serial form in 1945–1946 and as a novel in 1951. It was originally intended for adults but is often read by adolescents for its themes of angst and alienation, and as a critique on superficiality in society. The novel also deals with complex issues of identity, belonging, connection, and alienation.

The novel's antihero, Holden Caulfield, has become an icon for teenage rebellion. The novel was included on Time's 2005 list of the 100 best English-language novels written since 1923, and it was named by Modern Library and its readers as one of the 100 best English-language novels of the 20th century."""
    )

    private fun createLordOfTheFlies() = Book(
        id = "lord_of_the_flies",
        title = "Lord of the Flies",
        author = "William Golding",
        image = R.drawable.lftf,
        text = """Lord of the Flies is a 1954 novel by the Nobel Prize-winning British author William Golding. The plot concerns a group of British boys who are stranded on an uninhabited island and their disastrous attempts to govern themselves. Themes include the tension between groupthink and individuality, between rational and emotional reactions, and between morality and immorality.

The novel's title is a literal translation of Beelzebub, a Semitic deity which was worshipped in the Philistine city of Ekron. In Greek translations of the Hebrew Bible, the name Beelzebub appears as "lord of the flies".

The book was written during the Cold War, and the story is set during a fictional nuclear war. The book's themes include the conflict between civilization and savagery, the loss of innocence, and the inherent evil of human nature."""
    )

    private fun createAnimalFarm() = Book(
        id = "animal_farm",
        title = "Animal Farm",
        author = "George Orwell",
        image = R.drawable.farm,
        text = """Animal Farm is a satirical allegorical novella by George Orwell, first published in England on 17 August 1945. The book tells the story of a group of farm animals who rebel against their human farmer, hoping to create a society where the animals can be equal, free, and happy. Ultimately, the rebellion is betrayed, and the farm ends up in a state as bad as it was before, under the dictatorship of a pig named Napoleon.

According to Orwell, the fable reflects events leading up to the Russian Revolution of 1917 and then on into the Stalinist era of the Soviet Union. Orwell, a democratic socialist, was a critic of Joseph Stalin and hostile to Moscow-directed Stalinism, an attitude that was critically shaped by his experiences during the May Days conflicts between the POUM and Stalinist forces during the Spanish Civil War."""
    )

    private fun createTheHobbit() = Book(
        id = "the_hobbit",
        title = "The Hobbit",
        author = "J.R.R. Tolkien",
        image = R.drawable.hobbit,
        text = """The Hobbit, or There and Back Again is a children's fantasy novel by English author J. R. R. Tolkien. It was published on 21 September 1937 to wide critical acclaim, being nominated for the Carnegie Medal and awarded a prize from the New York Herald Tribune for best juvenile fiction. The book remains popular and is recognized as a classic in children's literature.

The Hobbit is set within Tolkien's fictional universe and follows the quest of home-loving Bilbo Baggins, the titular hobbit, to win a share of the treasure guarded by Smaug the dragon. Bilbo's journey takes him from his light-hearted, rural surroundings into more sinister territory.

The story is told in the form of an episodic quest, and most chapters introduce a specific creature or type of creature of Tolkien's geography. Bilbo gains a new level of maturity, competence, and wisdom by accepting the disreputable, romantic, fey, and adventurous sides of his nature and applying his wits and common sense."""
    )

    private fun createFahrenheit451() = Book(
        id = "fahrenheit_451",
        title = "Fahrenheit 451",
        author = "Ray Bradbury",
        image = R.drawable.f451,
        text = """Fahrenheit 451 is a 1953 dystopian novel by American writer Ray Bradbury. Often regarded as one of his best works, the novel presents a future American society where books are outlawed and "firemen" burn any that are found. The book's tagline explains the title: "Fahrenheit 451 – the temperature at which book paper catches fire, and burns".

The novel follows Guy Montag, a fireman who becomes disillusioned with his role of censoring literature and destroying knowledge, eventually quitting his job and committing himself to the preservation of literary and cultural writings.

The novel has been the subject of interpretations focusing on the historical role of book burning in suppressing dissenting ideas. In a 1956 radio interview, Bradbury said that he wrote Fahrenheit 451 because of his concerns about the threat of book burning in the United States."""
    )

    private fun createBraveNewWorld() = Book(
        id = "brave_new_world",
        title = "Brave New World",
        author = "Aldous Huxley",
        image = R.drawable.bnw,
        text = """Brave New World is a dystopian social science fiction novel by English author Aldous Huxley, written in 1931 and published in 1932. Largely set in a futuristic World State, inhabited by genetically modified citizens and an intelligence-based social hierarchy, the novel anticipates huge scientific advancements in reproductive technology, sleep-learning, psychological manipulation and classical conditioning that are combined to make a dystopian society which is challenged by only a single individual: the story's protagonist.

Huxley followed this book with a reassessment in essay form, Brave New World Revisited (1958), and with his final novel, Island (1962), the utopian counterpart. The novel is often compared to George Orwell's Nineteen Eighty-Four (1949).

In 1999, the Modern Library ranked Brave New World at number 5 on its list of the 100 best English-language novels of the 20th century."""
    )

    private fun createTheAlchemist() = Book(
        id = "the_alchemist",
        title = "The Alchemist",
        author = "Paulo Coelho",
        image = R.drawable.alc,
        text = """The Alchemist is a novel by Brazilian author Paulo Coelho that was first published in 1988. Originally written in Portuguese, it became a widely translated international bestseller. An allegorical novel, The Alchemist follows a young Andalusian shepherd in his journey to the pyramids of Egypt, after having a recurring dream of finding a treasure there.

The Alchemist was written by Paulo Coelho in 1987. The novel was inspired by a tale in Jorge Luis Borges's collection Tales of the Thousand and One Nights. The story is about a shepherd boy named Santiago who dreams of finding a worldly treasure as he travels to the pyramids of Egypt. Along the way, he meets many spiritual advisors who point him in the right direction for his quest.

The book has been translated into 80 different languages and has sold more than 65 million copies in more than 150 countries, becoming one of the best-selling books in history."""
    )
}