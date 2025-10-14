document.addEventListener('DOMContentLoaded', function () {
    // 1️ 스크롤 기준 요소를 자동으로 감지
    const fullContainer = document.getElementById('full-container');
    const wrapContainer = document.getElementById('wrap');

    // 2️ 실제 스크롤 대상(container) 결정
    // 메인 페이지에는 full-container, 서브 페이지에는 wrap이 존재함
    const container = fullContainer || wrapContainer || document.documentElement;

    // 3️ 버튼 요소
    const scrollToTopBtn = document.getElementById('scrollToTopBtn');

    // 4️ 필수 요소 확인 (둘 다 없으면 코드 종료)
    if (!container || !scrollToTopBtn) return;

    // 5 ️버튼 보이기/숨기기 로직
    function toggleScrollTopButton() {
        const scrollPos = container.scrollTop;
        scrollToTopBtn.style.display = scrollPos > 100 ? 'flex' : 'none';
    }

    // 6️ 스크롤 시 버튼 표시 토글
    container.addEventListener('scroll', () => {
        requestAnimationFrame(toggleScrollTopButton);
    });

    // 7️ 버튼 클릭 시 부드럽게 맨 위로 이동
    scrollToTopBtn.addEventListener('click', () => {
        container.scrollTo({ top: 0, behavior: 'smooth' });
    });

    // 8️ 초기 상태 체크
    toggleScrollTopButton();
});
