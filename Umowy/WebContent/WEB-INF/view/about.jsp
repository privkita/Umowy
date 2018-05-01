<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Umowy</title>
<link rel="stylesheet" href="assets/css/styles.css">
</head>
<body>
	<div class="container">
		<div class="header">
			<h1 class="header-heading">UMOWA 5000</h1>
		</div>
		<div class="nav-bar">
			<ul class="nav">
				<li><a href="/Umowy/index">START</a></li>
				<li><a href="/Umowy/contracts?filtr=wszystkie">UMOWY</a></li>
				<li><a href="/Umowy/systems">SYSTEMY</a></li>
				<li><a href="#">O APLIKACJI</a></li>
			</ul>
		</div>
		<div class="content">
		<br>
		<h4>O AUTORZE</h4>
		<hr>
		<p>Popełniający tę aplikację, jakże młody człek u progu swej kariery to ambitna i 
			sumienna osoba pełna determinacji i gotowa do poświęceń aby osiągnąć cel. 
			Komunikatywność, łatwość nawiązywania kontaktów, poczucie humoru oraz wrodzona 
			skromność sprawia, że świetnie odnajduje się w pracy zespołowej.
		<p>Pierwszej ze swoich pasji jaką są komputery zasmakował już w podstawówce. Zachłyśnięty
			technologią i możliwościami jakie niósł ze sobą ZX Spectrum, stawiał pierwsze kroki 
			w Basic'u robiąc wyczesane ramki i stringi jakich mało a dalej efekty specjalne od 
			których kopara opada po dziś dzień.</p>
		<p>Pomimo dłuższego związku w który wpadł ze swą drugą pasją jaką jest motoryzacja, nigdy 
			nie zapomniał o tej pierwszej i w swych doświadczeniach zawodowych starał się sobie 
			pozwalać z nią na małe tête-à-tête</p>
		<br>
		<p>Serdecznie pozdrawiam czytających i zapraszam do zapoznania się z aplikacją a za 
			poświęcony czas pragnę podziękować wesołą niespodzianką na końcu tej zakładki</p>
		<br>
		<br>
		<h4>O APLIKACJI</h4>
		<hr>
		<p>Aplikacja ta została zaprojektowana w celu wspomagania zarządzania umowami i służy 
			do przechowywania w bazie danych podstawowych informacji o systemach a także o umowach 
			z klientami,  których są właścicielami.</p>
		<h5>Drzewo aplikacji</h5>
		<hr>
		<h5>START</h5>
		<ul>
			<li>UMOWY</li>
			<ul>
				<li>AKTYWNE</li>
				<li>WSZYSTKIE</li>
				<li>NOWA</li>
				<li>IMPORT</li>
			</ul>
			<li>SYSTEMY</li>
			<ul>
				<li>NOWY</li>
			</ul>
			<li>O APLIKACJI</li>
		</ul>
		<br>
		<h5>OMÓWIENIE FUNKCJI APLIKACJI</h5>
		<hr>
		<ul>
		<li>UMOWY – służy do przeglądania umów</li>
		<li>WSZYTKIE – wyświetla wszystkie umowy</li>
		<li>AKTYWNE – wyświetla tylko aktywne umowy</li>
		<li>NOWA – umożliwia dodanie nowej umowy do bazy systemu</li>
		<li>IMPORT – umożliwia wczytanie danych z pliku w formacie Microsoft Excel</li>
		<li>SYSTEMY – służy do przeglądania systemów</li>
		<li>NOWY – dodawanie nowych systemów</li>
		<li>O APLIKACJI – w której właśnie się znajdujesz - można przeczytać krótki opis 
			aplikacji</li>
		</ul>
		<br>
		<h5>Aplikacja ta przechowuje następujące informacje o umowach:</h5>
		<ul>
			<li>Numer – unikatowy numer identyfikacyjny umowy</li>
			<li>System – nazwa systemu którego umowa dotyczy</li>
			<li>Data od – data od której obowiązuje umowa</li>
			<li>Data do – data do której obowiązuje umowa</li>
			<li>Wpływy – kwota wpływów z umowy</li>
			<li>Za okres – informacja w jakich odstępach czasowych mają następować  wpływy</li>
			<li>Aktywna – informacja czy umowa jest aktywna</li>
		</ul>
		<br>
		<h5>W Systemie są przechowywane następujące informacje o umowach:</h5>
		<ul>
			<li>Nazwa – unikatowa nazwa systemu</li>
			<li>Opis – opis funkcjonalności systemu</li>
			<li>Technologie – lista i opis wykorzystanych w systemie technologii</li>
			<li>Klient – nazwa właściciela systemu</li>
		</ul>
		<br>
		<h5>DODAWANIE NOWEJ UMOWY</h5>
		<hr>
		<p>Podczas wprowadzania nowej umowy należy podać wszystkie jej parametry.</p>
		<p>Numer umowy jest jej unikatowym identyfikatorem, system automatycznie sprawdzi 
			czy podany numer już występuje w bazie danych i jeśli tak jest wyświetli 
			odpowiedni komunikat.</p>
		<p>UWAGA należy upewnić się, że przed dodaniem umowy w systemie jest już wprowadzony 
			system którego umowa ma dotyczyć. W przeciwnym wypadku nie będzie on dostępny 
			w polu wyboru systemu.</p>
		<p>Daty rozpoczęcia i zakończenia obowiązywania umowy należy podawać w formacie 
			rrrr-mm-dd gdzie:</p>
		<ul>
			<li>rrrr – reprezentuje czterocyfrowo zapisany rok</li>
			<li>mm – reprezentuje dwucyfrowo zapisany miesiąc</li>
			<li>dd – reprezentuje dwucyfrowo zapisany dzień</li>
		</ul>
		<p>Podczas wprowadzania daty można również skorzystać z wbudowanego formularza.</p>
		<p>Następnie wpisujemy kwotę, z okienka wyboru wybieramy rodzaj kwoty netto lub brutto, 
			podajemy okres rozliczenia, ustawiamy czy umowa jest aktywna czy nie i klikamy 
			ZAPISZ.</p>
		<br>
		<h5>EDYCJA UMOWY</h5>
		<hr>
		<p>Edycja umowy przebiega identycznie jak dodawanie nowej z tą różnicą, że nie podajemy numeru umowy. 
			Pozycja ta jest zablokowana do edycji.</p>
		<p>W przypadku podania błędnego któregokolwiek parametru żadna z wprowadzonych zmian nie zostanie 
			zapisana.</p>
		<br>
		<h5>KASOWANIE UMOWY</h5>
		<hr>
		<p>Kasowanie umów w systemie jest niemożliwe. Jedyną dozwoloną opcją jest ustawienie umowy 
			jako nieaktywnej poprzez wybór w edycji umowy opcji AKTYWNA na NIE</p>
		<br>
		<h5>DODAWANIE NOWEGO SYSTEMU</h5>
		<hr>
		<p>Podczas wprowadzania nowego systemu należy podać wszystkie jego parametry.</p>
		<p>Nazwa systemu jest jego unikatowym identyfikatorem, system automatycznie sprawdzi, 
			czy podana nazwa już występuje w bazie danych i jeśli tak jest wyświetli odpowiedni 
			komunikat. W przeciwnym wypadku zezwoli na utworzenie systemu o podanej nazwie, 
			pod warunkiem, że pozostałe parametry zostały wprowadzone do formularza.</p>
		<br>
		<br>
		<h4>O AUTORZE</h4>
		<hr>
		<p>Popełniający tę aplikację, jakże młody człek u progu swej kariery to ambitna i 
			sumienna osoba pełna detrminacji i gotowa do poświęceń aby osiagnąć cel. Komunikatywność,
			łatwość nawiązywania kontaktów, poczucie humoru oraz wrodzona skromność sprawia, że
			świetnie odnajduje się w pracy zespołowej.
		<p>Pierwszej ze swoich pasji jaką są komputery zasmakował już w podstawówce. Zachłyśnięty
			technologią jaką niósł ze sobą ZX Spectrum, stawiał pierwsze kroki w Basic'u robiąc
			wyczesane ramki i stringi jakich mało a dalej efekty specjalne od których kopara opada
			po dziś dzień.</p>
		<p>Pomimo dłuższego związku w który wpadł ze swą drugą pasją jaką jest motoryzacja, nigdy 
			nie zapomniał o tej pierwszej i w swych doświadczeniach zawodowych starał się sobie 
			pozwalać z nią na małe tête-à-tête</p>
		<hr>
		<iframe src="https://giphy.com/embed/oRJbHBJetc6is" width="480" height="270" frameBorder="0" 
			class="giphy-embed" allowFullScreen></iframe>
		<p><a href="https://giphy.com/gifs/lemur-oRJbHBJetc6is">via GIPHY</a></p>
		<p>Chcąc uświęcić międzynarodowe święto klasy robotniczej zwane też Świętem Pracy 
			autor w pełni szczęśliwy ukończył program ten dnia 1.05.2018</p>
		</div>
		<div class="footer">
			&copy; Copyright 2018
		</div>
	</div>
</body>
</html>