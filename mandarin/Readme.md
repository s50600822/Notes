

All [pinyins](https://en.wiktionary.org/wiki/Appendix:Mandarin_Pinyin/Table_of_General_Standard_Chinese_Characters#YIN).


```js
const pinyinList = [];
const rows = document.querySelectorAll('.wikitable tbody tr');

rows.forEach(row => {
  const cells = row.querySelectorAll('td');
  cells.forEach((cell, index) => {
    if (index === 0) {
      const pinyin = cell.textContent.trim();
      pinyinList.push(pinyin);
    }
  });
});

console.log(pinyinList);

[...new Set(pinyinList.map(p => `('${p.toLowerCase()}')`))].join(',')
```