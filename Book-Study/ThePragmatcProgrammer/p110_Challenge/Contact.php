<?php

class Contact
{
    public $name;
    public $phoneNumber;

    public function __construct($name, $phoneNumber)
    {
        $this->name = $name;
        $this->phoneNumber = $phoneNumber;
    }
}

// 주소록 데이터 저장
function saveContactsToFile($contacts, $filename)
{
    $file = fopen($filename, 'wb'); // wb ; binary write mode
    foreach ($contacts as $contact) {
        $packedData = pack("A30A15", $contact->name, $contact->phoneNumber); // A30 : 30 byte name, A15 15 byte phoneNumber
        file_put_contents('/tmp/log/dev.log', $packedData.PHP_EOL, 8);
        fwrite($file, $packedData);
    }
    fclose($file);
}

// 주소록 데이터 로드
function loadContactsFromFile($filename)
{
    $contacts = [];
    $file = fopen($filename, "rb"); // rb : binary read mode
    while (!feof($file)) { // feof : end of file
        $binaryData = fread($file, 45); // fetch 45 byte data
        if (!empty($binaryData)) {
            $data = unpack("A30name/A15phoneNumber", $binaryData);
            $contacts[] = new Contact($data['name'], $data['phoneNumber']);
        }
    }
    fclose($file);
    return $contacts;
}

// 주소록 데이터 추가
function addContact($name, $phoneNumber, $filename)
{
    $contact = new Contact($name, $phoneNumber);
    $contacts = loadContactsFromFile($filename);
    $contacts[] = $contact;
    saveContactsToFile($contacts, $filename);
}

// 주소록 데이터 추가 예시
addContact("John Doe", "123-456-7890", "address_book.bin");
addContact("Jane Smith", "987-654-3210", "address_book.bin");

// 주소록 데이터 로드 예시
$contacts = loadContactsFromFile("address_book.bin");
foreach ($contacts as $contact) {
    echo "Name: " . $contact->name . ", Phone: " . $contact->phoneNumber . "\n";
}

?>